package com.ninja.test.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver; 
	
    @FindBy(linkText = "HP LP3065")
	private WebElement productDisplayed;
    
    @FindBy(xpath = "//h2[text()='Products meeting the search criteria']")
    private WebElement invalidProductCheck; 
   
    
    public SearchPage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public  boolean productIsDisplayed() {
    	boolean check = productDisplayed.isDisplayed(); 
    	return check; 
    }
    
    public boolean invalidProductCheck() {
    	boolean check = invalidProductCheck.isDisplayed(); 
    	return check; 
    }
    
  
    
    
}
