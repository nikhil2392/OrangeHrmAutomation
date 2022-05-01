package com.OrangeHRMAutomation.CyberSuccess;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends ExcelUtil{
  @Test(dataProvider="ExcelDataProvider")
  public void login(Object username, Object password) throws InterruptedException {
	
	  String un=username.toString();
	  String pw=password.toString();
	  
	if(un.equals("Admin")&&(pw.equals("admin123"))) {

	  LoginPage loginPage=new LoginPage();
	  loginPage.login(username.toString(), String.valueOf(password));
	  
	  driver.findElement(By.xpath("//a[@id='welcome']")).click();
	  
	  Thread.sleep(3000);
	  
	  driver.findElement(By.linkText("Logout")).click();
	  }
	
	else {
		 LoginPage loginPage=new LoginPage();
		  loginPage.login(username.toString(), String.valueOf(password));
		}
	  
	  System.out.println(username.toString()+"----"+password.toString());
	  
  }
  
  @DataProvider(name="ExcelDataProvider")
  public Object[][] getData() throws IOException{
	  
	  String filePath="C:\\Users\\HP\\Documents\\Book1.xlsx";
	  
	 return getExcelData(filePath, "Sheet1");
	  
  }
  
  @BeforeClass
  public void beforeClass() {

		getBrowserLaunch("Chrome");

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
  }
}
