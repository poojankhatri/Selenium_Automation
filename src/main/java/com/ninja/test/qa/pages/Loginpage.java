package com.ninja.test.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver; 
	
	@FindBy(id="input-email")
	private WebElement emailAddressField; 
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton; 
	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertWarningDisplay; 
	
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterEmailAddres(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public AccountPage loginButton() {
		loginButton.click();
		return new AccountPage(driver); 
	}
	
	
	public boolean checkAlertWarning() {
		boolean check = alertWarningDisplay.isDisplayed(); 
		return check; 
	}
	
	
	
	

}
