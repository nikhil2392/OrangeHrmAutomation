package com.OrangeHRMAutomation.CyberSuccess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws Exception {
System.setProperty("webdriver.chrome.driver", "C:\\Tools\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		try {
		
		driver.get("https://google.com");
		
		System.out.println("Title of the Google page is :"+driver.getTitle());
		
		if(driver.getTitle().equals("Giigle"))
		{
			System.out.println("Successfully Validated the title");
		}
		else
		{
			throw new Exception("Fail to validate the Title of Google Page");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			driver.close();
		}
	}

}
