package com.ninja.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ninja.test.base.Base;
import com.ninja.test.qa.DynamicEmailMethod;
import com.ninja.test.qa.pages.AccountPage;
import com.ninja.test.qa.pages.HomePage;
import com.ninja.test.qa.pages.Loginpage;

import junit.framework.Assert;

public class Login extends Base {
	WebDriver driver;
	Loginpage LoginPage;

	@AfterMethod
	public void closeMethod() {
		driver.quit();
	}

	// We have created a basic method to use the same code so we don't have to right
	// it again.
	@BeforeMethod
	public void commonDataMethodForAllMethods() {
		loadPropertiesFile();
		driver = browserCheck(prop.getProperty("browser"));
		HomePage hp = new HomePage(driver);
		hp.accountDropMenu();
		LoginPage = hp.selectingLoginOptions();
	}

	@DataProvider(name = "testDataOneMethod")
	public Object[][] dataSupplier() {
		Object[][] data = DynamicEmailMethod.getDataFromTheExcel("Login");
		return data;
	}

	@Test(priority = 1, dataProvider = "testDataOneMethod")
	public void verifyLoginWithValidCredentials(String email, String password) {
		LoginPage.enterEmailAddres(email);
		LoginPage.enterPassword(password);
		AccountPage AccountPage = LoginPage.loginButton();
		Assert.assertTrue(AccountPage.accountInformation());
	}

	@Test(priority = 2)
	public void loginWithInvalidCredentials() {
		LoginPage.enterEmailAddres(DynamicEmailMethod.createEmailDynamically());
		LoginPage.enterPassword(prop.getProperty("invalidPassword"));
		LoginPage.loginButton();
		Assert.assertTrue(LoginPage.checkAlertWarning());
	}

	@Test(priority = 3)
	public void loginWithInvalidEmailAndValidPassword() {

		LoginPage.enterEmailAddres(DynamicEmailMethod.createEmailDynamically());
		LoginPage.enterPassword(prop.getProperty("validPassword"));
		LoginPage.loginButton();
		Assert.assertTrue(LoginPage.checkAlertWarning());
	}

	@Test(priority = 4)
	public void loginWithValidEmailAndInvalidPassword() {
		LoginPage.enterEmailAddres(prop.getProperty("validEmail"));
		LoginPage.enterPassword(prop.getProperty("invalidPassword"));
		LoginPage.loginButton();
		Assert.assertTrue(LoginPage.checkAlertWarning());
	}

	@Test(priority = 5)
	public void loginWithoutAnyCredentials() {
		LoginPage.loginButton();
		Assert.assertTrue(LoginPage.checkAlertWarning());
	}
}
