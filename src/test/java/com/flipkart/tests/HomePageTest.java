package com.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.Base;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;

public class HomePageTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		logger.info("************Started HomePageTest*****************");
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();

		loginpage.closeLoginPopup();

	}

	@Test
	public void validateLoginBtnTest() {
		logger.info("************Checking validateLoginBtnTest on Homepage*****************");
		Assert.assertTrue(homepage.getLoginButton());

	}

	@AfterMethod
	public void tearDown() {
		logger.info("************Completed HomePageTest*****************");
		driver.quit();

	}

}
