package com.OrangeHRMAutomation.CyberSuccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandling {
	
         Properties property;
         
         PropertyHandling() throws FileNotFoundException{
        	 
        	 String filePath="F:\\Study\\EC\\CyberSuccess\\config.Properties";
        	 
        	 FileInputStream input = new FileInputStream(filePath);
        	 
        	 property=new Properties();
        	 
        	 try {
				property.load(input);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        	 
         }
         
         public String getValue(String key) {
        	 
        	 return property.getProperty(key);
        	 
        	   }	
}
