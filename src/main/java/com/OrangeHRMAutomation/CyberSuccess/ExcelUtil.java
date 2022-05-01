package com.OrangeHRMAutomation.CyberSuccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil extends BaseClass {
	
	static Workbook wb;
	
	static Row row;
	
	static Sheet sheet;
	
	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
		
//		String filePath = "C:\\Users\\HP\\Documents\\Book1.xlsx";
		
		FileInputStream input=new FileInputStream(filePath);
		
		getWorkBookInstance(filePath, input);
		
		sheet = wb.getSheet(sheetName);
		
		int totalRows=sheet.getLastRowNum()+1;
		
		System.out.println("Total number of  rows :"+(totalRows));
		
		row = sheet.getRow(0);
		
		int totalCol=row.getPhysicalNumberOfCells();
		
		System.out.println("Total number of  columns :"+totalCol);
		
		Object[][] excelObject=new Object[totalRows][totalCol];
		
		for(int i=0; i<totalRows; i++) {
			
			for(int j=0; j<totalCol; j++) {
				
				Cell cell=sheet.getRow(i).getCell(j);
				
				excelObject[i][j]= Objects.isNull(cell) ? null : getCellData(cell);
					}
			}
		return 	excelObject;
	}
	
	public static Object getCellData(Cell cell)
	{
		switch(cell.getCellType()) {
		case NUMERIC :
			return cell.getNumericCellValue();
		case STRING :
			return cell.getStringCellValue();
		case BOOLEAN : 
			return cell.getBooleanCellValue();
		default :
			return "";
		}
	}
	
private static void getWorkBookInstance(String filePath, FileInputStream input) throws IOException {
		
String extension=filePath.substring(filePath.indexOf("."));
		
//		System.out.println(extension);
		
		if(extension.equals(".xlsx")) {
		
		     wb = new XSSFWorkbook(input);
		
		}
		else if(extension.equals(".xls")) {
			
			 wb = new HSSFWorkbook(input);
		}
		
	}
	
	public static void setExcelData(String filePath,String sheetName, int rowNum, int colNum,String value) throws IOException {
		
		FileInputStream input = new FileInputStream(filePath);
		
		getWorkBookInstance(filePath, input);
		
		if(Objects.isNull(wb.getSheet(sheetName))) {
			
			wb.createSheet(sheetName);
		}
		else {
			wb.getSheet(sheetName);
		}
		Row row = sheet.createRow(rowNum);
		row.createCell(colNum).setCellValue(value);
		
		FileOutputStream output=new FileOutputStream(filePath);
		
		wb.write(output);
		
		wb.close();
		
		
	}
	

}
