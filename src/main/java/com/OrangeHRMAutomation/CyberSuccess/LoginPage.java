package com.OrangeHRMAutomation.CyberSuccess;

import org.openqa.selenium.By;

public class LoginPage extends BaseClass {
	 
	public void login(String username, String password)
	{   driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).submit();
	}

}
