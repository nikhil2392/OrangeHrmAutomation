package com.OrangeHRMAutomation.CyberSuccess;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SampleSeleniumCode extends BaseClass {

	public static void main(String[] args) {
	
	
	getBrowserLaunch("browser");
	
	driver.navigate().to("https://www.amazon.in/amezon/s?k=amezon");
	
	driver.findElement(By.id("nav-search-dropdown-card")).click();
	
	Select select=new Select(driver.findElement(By.id("nav-search-dropdown-card")));
	
	select.selectByValue("Electronics");
	
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("televisison");
	
	driver.findElement(By.id("nav-search-submit-button")).click();
	
	
	
	
	}

}
