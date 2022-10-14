package com.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.Base;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;

public class LoginPageTest extends Base {

	LoginPage loginPage;
	HomePage homepage;

	String expectedTitle = "Online Shopping Site for Mobiles, Electronics,"
			+ " Furniture, Grocery, Lifestyle, Books & More. Best Offers!";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		logger.info("************Started LoginPageTest*****************");
		initialization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		logger.info("************ Validating loginPageTitleTest*****************");
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualLoginPageTitle, expectedTitle);

	}

	@Test(priority = 2)
	public void loginTest() throws Throwable {
		logger.info("************ Validating loginTest*****************");
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		logger.info("************Completed LoginPageTest*****************");
		driver.quit();
	}

}
