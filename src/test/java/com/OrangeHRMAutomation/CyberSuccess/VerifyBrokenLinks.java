package com.OrangeHRMAutomation.CyberSuccess;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class VerifyBrokenLinks extends BaseClass{

	public static void main(String[] args) {
		getBrowserLaunch("browser");
		
		driver.navigate().to("https://www.amazon.in/");
		
		List<WebElement> linkElement=driver.findElements(By.tagName("a"));

		linkElement.forEach((element)->{
			String links=element.getAttribute("href");
			
			if(Objects.nonNull(links) && links.startsWith("http"))
			{
				try
				{
					URL url=new URL(links);
					
					URLConnection connection=url.openConnection();
					
					HttpURLConnection httpConnect=(HttpURLConnection)connection;
					
					httpConnect.connect();
					
					int statusCode=httpConnect.getResponseCode();
					
					if (statusCode!=200)
					{
						System.out.println("Broken URL"+statusCode+""+links);
					}
				 	
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		}
	}


