package com.ninja.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.test.base.Base;
import com.ninja.test.qa.DynamicEmailMethod;
import com.ninja.test.qa.pages.HomePage;
import com.ninja.test.qa.pages.RegisterPage;

import junit.framework.Assert;

public class Register extends Base {
	WebDriver driver;
	RegisterPage RegisterPage; 
	
	@BeforeMethod
	public void commonOptimizedMethod() {
		loadPropertiesFile(); 
		driver =  browserCheck(prop.getProperty("browser"));
		HomePage hp = new HomePage(driver); 
		hp.accountDropMenu();
	    RegisterPage = hp.selectingRegisterOptions(); 
	}
	
	
	@AfterMethod
	public void quitMethod() {
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifyRegisterUsingMandatoryFields() {
		RegisterPage.firstName(prop.getProperty("firstName"));
		RegisterPage.lastName(prop.getProperty("lastName"));
		RegisterPage.email(DynamicEmailMethod.createEmailDynamically());
		RegisterPage.telephone(prop.getProperty("telephone"));
		RegisterPage.validPassword(prop.getProperty("validPassword"));
		RegisterPage.confirmPassword(prop.getProperty("validPassword"));
		RegisterPage.confirmAgreeButton();
		RegisterPage.continueButton();
		Assert.assertTrue(RegisterPage.accountCreatedCheck()); 
	}
	
	@Test(priority=2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		RegisterPage.firstName(prop.getProperty("firstName"));
		RegisterPage.lastName(prop.getProperty("lastName"));
		RegisterPage.email(DynamicEmailMethod.createEmailDynamically());
		RegisterPage.telephone(prop.getProperty("telephone"));
		RegisterPage.validPassword(prop.getProperty("validPassword"));
		RegisterPage.confirmPassword(prop.getProperty("validPassword"));
		RegisterPage.checkNewsletterYes();
		RegisterPage.confirmAgreeButton();
		RegisterPage.continueButton();
		Assert.assertTrue(RegisterPage.accountCreatedCheck()); 
	}
	
	
	@Test(priority=3)
	public void verifyWithExistingEmailAddress() {
		RegisterPage.firstName(prop.getProperty("firstName"));
		RegisterPage.lastName(prop.getProperty("lastName"));
		RegisterPage.email(prop.getProperty("validEmail"));
		RegisterPage.telephone(prop.getProperty("telephone"));
		RegisterPage.validPassword(prop.getProperty("validPassword"));
		RegisterPage.confirmPassword(prop.getProperty("validPassword"));
		RegisterPage.checkNewsletterYes(); 
		RegisterPage.confirmAgreeButton();
		RegisterPage.continueButton();
		String actualWarning =RegisterPage.emailAddressWarning(); 
		Assert.assertTrue(actualWarning.contains(prop.getProperty("emailAddressRegisterWarning"))); 
	}
	@Test(priority=4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		
		RegisterPage.continueButton();
		
		String actualPrivacyPolicyWarning = RegisterPage.emailAddressWarning(); 
		Assert.assertTrue(actualPrivacyPolicyWarning.contains(prop.getProperty("privacyPolicyWarning")));
		
		String actualFirstName = RegisterPage.firstNameWarning();
		Assert.assertTrue(actualFirstName.contains(prop.getProperty("firstNameWarning"))); 
		
		String actualLastName = RegisterPage.lastNameWarning(); 
		Assert.assertTrue(actualLastName.contains(prop.getProperty("lastNameWarning")));
		
		String actualEmail = RegisterPage.emailWarningCheck();
		Assert.assertTrue(actualEmail.contains(prop.getProperty("emailWarning")));
		
		String actualTelephone = RegisterPage.telephoneWarning();
		Assert.assertTrue(actualTelephone.contains(prop.getProperty("telephoneWarning")));
		
		String actualPassword =RegisterPage.warningPassword();
		Assert.assertTrue(actualPassword.contains(prop.getProperty("passwordWarning")));
		
	}
	
	
}
