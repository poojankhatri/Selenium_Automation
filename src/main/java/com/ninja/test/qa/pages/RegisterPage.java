package com.ninja.test.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver; 
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField; 
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField; 
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasword;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement confirmAgreeButton;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement confirmContinueButton;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement accountCreatedSuccessfully; 
	
	@FindBy(xpath="//input[@name='newsletter'][@value=1]")
	private WebElement newsletterFieldCheck;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailAddressWarning;
	
	@FindBy(xpath = "//input[@name='firstname']/following-sibling::div")
	private WebElement firtsNameWarning;
	
	@FindBy(xpath = "//input[@name='lastname']/following-sibling::div")
	private WebElement lastNameWarning; 
	
	@FindBy(xpath = "//input[@name='email']/following-sibling::div")
	private WebElement emailWarning;
	
    @FindBy(xpath = "//input[@name='telephone']/following-sibling::div")
	private WebElement telephone;
    
    @FindBy(xpath = "//input[@name='password']/following-sibling::div")
    private WebElement passwordWarning; 
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	public void firstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void lastName(String LastName) {
		lastNameField.sendKeys(LastName);
	}
	
	public void email(String email){
		emailField.sendKeys(email);
	}
	
	public void telephone(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	
	public void validPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void confirmPassword(String confirmPassword) {
		confirmPasword.sendKeys(confirmPassword);
	}
	
	public void confirmAgreeButton() {
		confirmAgreeButton.click();
	}
	
	public void continueButton() {
		confirmContinueButton.click();
	}
	
	public boolean accountCreatedCheck() {
		boolean check = accountCreatedSuccessfully.isDisplayed(); 
		return check; 
	}
	
	public void checkNewsletterYes() {
		newsletterFieldCheck.click();
	}
	
	public String emailAddressWarning() {
		String warning = emailAddressWarning.getText(); 
		return warning; 
	}
	
	public String firstNameWarning() {
		String warning = firtsNameWarning.getText(); 
		return warning; 
	}
	
	public String lastNameWarning() {
		String warning = lastNameWarning.getText(); 
		return warning; 
	}
	
	public String emailWarningCheck() {
		String warning = emailWarning.getText(); 
		return warning; 
	}
	
	public String telephoneWarning() {
		String warning = telephone.getText(); 
		return warning; 
	}
	
	public String warningPassword() {
		String warning =  passwordWarning.getText(); 
		return warning; 
	}
	
	
	
}
