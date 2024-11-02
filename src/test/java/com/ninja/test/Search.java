package com.ninja.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.test.base.Base;
import com.ninja.test.qa.pages.HomePage;
import com.ninja.test.qa.pages.SearchPage;

import junit.framework.Assert;

public class Search extends Base{
	WebDriver driver; 
	
	@AfterMethod 
	// This method will be invoke after the all methods 
	public void quitMethod() {
		driver.quit();
	}
	@BeforeMethod
	public void codeOptimizedMethod() {
		loadPropertiesFile(); 
		driver = browserCheck(prop.getProperty("browser")); 
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		HomePage hp = new HomePage (driver); 
		SearchPage SearchPage = hp.selectingSearchOptions(prop.getProperty("validProduct"));
		Assert.assertTrue(SearchPage.productIsDisplayed());
	}
	@Test(priority=2)
	public void verifySearchWithNonExistingProductName() {
		HomePage hp = new HomePage (driver); 
		SearchPage SearchPage = hp.selectingSearchOptions(prop.getProperty("invalidProduct"));
		Assert.assertTrue(SearchPage.invalidProductCheck());
	}
	@Test(priority=3)
	public void verifyWithoutAnyProductName() {
		driver.findElement(By.name("search")).sendKeys(Keys.ENTER);	
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).isDisplayed());
	}

}
