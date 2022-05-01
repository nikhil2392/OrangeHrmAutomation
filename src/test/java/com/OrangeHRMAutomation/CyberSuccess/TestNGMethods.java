package com.OrangeHRMAutomation.CyberSuccess;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestNGMethods extends BaseClass {
	PropertyHandling p;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws FileNotFoundException {
		
	    p=new PropertyHandling();
		
		System.out.println("This is before cls method run before the class...");
//		System.out.println("Generally we prefer the before class method instead of before method");
		getBrowserLaunch(browser);
		  
		driver.get(p.getValue("OrangeHRMurl"));
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is after cls method run After the class...");
	}
	
	@BeforeSuite
	public void beforeSuit() {
		
		System.out.println("Inside before suit method.....");
		
	}
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Inside b4 test method");
	}
	
	@AfterTest
	public void afterTest() {
		
		System.out.println("Inside after test method");
	}
	
	
	
	
	@AfterSuite
	public void afterSuit() {
		
		System.out.println("Inside After suit method.....");
		
	}
	
	
	/*
	 * @BeforeMethod public void beforeMethod() {
	 * System.out.println("Inside b4 method which runs before every test Method");
	 * // we declare it only once but still it can run for every @Test
	 * Annotation.... }
	 * 
	 * @AfterMethod public void afterMethod() {
	 * System.out.println("Inside after method which runs after every test Method");
	 * // we declare it only once but still it can run for every @Test
	 * Annotation.... }
	 */
	
	
  @Test(dependsOnMethods = "test2")
  public void test1() throws Exception {
	  
//       Thread.sleep(20000);
//	   throw new Exception("This is fake exception");
	   System.out.println("Inside test 1 method");
  }
  @Test( groups="Sanity")
  public void test2() {
	  
	  System.out.println("Inside test 2 method");
  }
  @Test(dependsOnMethods = "test1", alwaysRun=true, enabled=true)
  public void test3() {
	  
	  System.out.println("Inside test 3 method");
  }
  
  @Parameters({"username","password"})
  @Test
  public void login(String username, String password) {
	  
	  LoginPage loginPage = new LoginPage();
	  
	  loginPage.login(username, password);
	  
	  System.out.println(username+"  "+password);
	  
  }
  
}
