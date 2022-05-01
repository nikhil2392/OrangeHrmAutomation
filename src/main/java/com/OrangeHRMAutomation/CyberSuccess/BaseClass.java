package com.OrangeHRMAutomation.CyberSuccess;

import java.time.Duration;
import java.util.Random;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BaseClass {
	
	public static WebDriver driver=null;
	
	public static void getBrowserLaunch(String browser)
	{
		switch(browser) {
		
		case "Chrome" :	
			
	        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\ChromeDriver\\chromedriver.exe");
            driver=new ChromeDriver();
        
        break;
        
		case "Edge" :
	
			System.setProperty("webdriver.edge.driver", "C:\\Tools\\EdgeDriver\\msedgedriver.exe");
            driver=new EdgeDriver();
            
            break;
      /* case "Mozilla" :
            
		   System.setProperty("webdriver.geko.driver", "C:\\Tools\\ChromeDriver\\chromedriver.exe");
           driver=new MozillaDriver();
           
           break;*/
           
		default :
			
			System.setProperty("webdriver.chrome.driver", "C:\\Tools\\ChromeDriver\\chromedriver.exe");
            driver=new ChromeDriver();
			
		}
		
	}
	
			public static void validate(String actual, String expected) throws Exception
			{
				if(actual.equals(expected)) {
					System.out.println("Successfully validated "+ actual +" in the screen");
				}
				else {
					throw new Exception("Failed to validate the "+ actual +" with the "+ expected);
				}
			}
			
    public static String generateRandomString(int count)
	
    {
    	Random random=new Random();
    	
    	return random.ints(65,90).limit(count)
    			.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    	
    }
    
    @SuppressWarnings("unchecked")
	public static void fluentWait(By by)
    
    {
    	Wait wait=new FluentWait<WebDriver>(driver).
    			withTimeout(Duration.ofSeconds(10)).
    			pollingEvery(Duration.ofSeconds(2)).
    			ignoring(Exception.class);
    	
    	wait.until(new Function<WebDriver,WebElement>(){
    		
    		public WebElement apply(WebDriver driver) {
    			System.out.println("Applying Fluent Wait...");
    			
    			return driver.findElement(by);
    		}
    		
    	});
    	}
	
}	
	