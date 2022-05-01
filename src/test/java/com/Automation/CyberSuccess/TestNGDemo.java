package com.Automation.CyberSuccess;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGDemo {
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("Inside Before class Method");
		
	}
	@AfterClass
	public void afterClassMethod() {
		System.out.println("Inside Before class Method");
		
	}
 @Test
  public void testDemo1() {
	  System.out.println("Inside Test Demo1");
	  }
  
  @Test 
  public void testDemo2() {
	  System.out.println("Inside Test Demo2");
	 }
  
  @Test
  public void testDemo3() {
	  System.out.println("Inside Test Demo2");
  }
}
