package com.ninja.test.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver; 
	
	// These are the object that we are created by using the page object model of the selenium 
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu; 
	
	@FindBy(linkText="Login")
	private WebElement loginOptions;
	
	@FindBy(linkText= "Register")
	private WebElement registerOptions;
	
	@FindBy(name= "search")
	private WebElement searchOptions; 
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// Now lets create the actions class with the help of the objects
	// make sure for the actions we need to create the methods first 
	public void accountDropMenu() {
		myAccountDropMenu.click();
	}
	
	public Loginpage selectingLoginOptions() {
		loginOptions.click();
		return new Loginpage(driver); 
	}
	
	public RegisterPage selectingRegisterOptions() {
		registerOptions.click();
		return new RegisterPage(driver);
	}
	
	public SearchPage selectingSearchOptions(String productText) {
		searchOptions.sendKeys(productText,Keys.ENTER);
		return new SearchPage(driver); 
	}
	
	
}
