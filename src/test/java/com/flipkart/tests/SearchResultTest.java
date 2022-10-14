package com.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.base.Base;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.SearchResultPage;
import com.flipkart.utils.TestUtil;

public class SearchResultTest extends Base {

	LoginPage loginPage;
	HomePage homepage;
	SearchResultPage searchResultPage;

	String sheetName = "Sheet1";

	public SearchResultTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		logger.info("************Started SearchResultTest*****************");
		initialization();
		loginPage = new LoginPage();
		homepage = new HomePage();
		searchResultPage = new SearchResultPage();
		
		loginPage.closeLoginPopup();
		

	}

	@DataProvider(name = "HomePage TestData")
	public Object[][] getHomePageTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(dataProvider = "HomePage TestData")
	public void searchTest(String productName) {
		logger.info("************Checking searchTest*****************");
		searchResultPage = homepage.productSearch(productName);
		String actualSearchText = searchResultPage.getSearchText();
		logger.info("The product name you have searched :::: " + actualSearchText);
		Assert.assertEquals(actualSearchText, productName, "Search text not matching");

	}

	@AfterMethod
	public void tearDown() {
		logger.info("************Completed SearchResultTest*****************");
		driver.quit();
	}

}
