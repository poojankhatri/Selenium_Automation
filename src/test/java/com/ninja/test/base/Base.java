package com.ninja.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.ninja.test.qa.DynamicEmailMethod;

public class Base {
	WebDriver driver; 
	public Properties prop; 
	
	public void loadPropertiesFile(){
		prop = new Properties(); 
		File fs = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\config\\config.properties"); 
		try {
			FileInputStream fls = new FileInputStream(fs); 
			prop.load(fls);
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	 public  WebDriver browserCheck(String browserName) {
		 if(browserName.equalsIgnoreCase("Chrome")) {
			 driver = new ChromeDriver(); 
		 }else if (browserName.equalsIgnoreCase("Edge")) {
				 driver = new EdgeDriver(); 
		 }else if(browserName.equalsIgnoreCase("FireFox")) {
			 driver = new FirefoxDriver(); 
		 }else if(browserName.equalsIgnoreCase("Safari")) {
			 driver = new SafariDriver(); 
		 }else {
			 System.out.println("There is no browser please select the proper browser");
		 }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DynamicEmailMethod.implicitWaitTime)); 
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DynamicEmailMethod.pageLoadtimeOut)); 
		driver.get(prop.getProperty("url"));
		return driver; 
		
}
}
