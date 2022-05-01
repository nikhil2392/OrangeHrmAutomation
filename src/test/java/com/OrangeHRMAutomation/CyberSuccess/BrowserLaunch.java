package com.OrangeHRMAutomation.CyberSuccess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrowserLaunch extends BaseClass {

	public static void main(String[] args) throws Exception {
		
		PropertyHandling prop=new PropertyHandling();
		
		System.out.println(driver);
		getBrowserLaunch("Chrome");
		System.out.println(driver);
		driver.navigate().to(prop.getValue("OrangeHRMurl"));
		driver.navigate().back();
		System.out.println(driver.getTitle());
		validate(driver.getTitle(),"");
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		validate(driver.getTitle(), "OrangeHRM");
		
		LoginPage loginPage=new LoginPage();
		
		loginPage.login(prop.getValue("OrangeHRMusername"),prop.getValue("OrangeHRMpassword"));
		
	    WebElement module=driver.findElement(By.id("menu_pim_viewPimModule"));
	    
	    if(module.isDisplayed()) {
	    	System.out.println("Successfully Logged in to OrangeHRM");
	    }
		
	    else {
	    	throw new Exception("Fail to Log in");
	    }
		
		
		//driver.close();
		
		
		

	}

}
