package com.OrangeHRMAutomation.CyberSuccess;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PIMGetExcel extends BaseClass {
  @Test
  public void login() {
	  
	  getBrowserLaunch("browser");
		
		driver.navigate().to("https://www.amazon.in/amezon/s?k=amezon");
		
		driver.findElement(By.id("nav-search-dropdown-card")).click();
		
		Select select=new Select(driver.findElement(By.id("nav-search-dropdown-card")));
		
		select.selectByValue("Electronics");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("televisison");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	  }
}
