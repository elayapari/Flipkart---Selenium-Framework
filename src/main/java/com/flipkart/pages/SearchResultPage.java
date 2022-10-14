package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.Base;
import com.flipkart.utils.TestUtil;

public class SearchResultPage extends Base {

	@FindBy(xpath = "//span[@class='_10Ermr']/span")
	WebElement searchText;

	public SearchResultPage() {

		PageFactory.initElements(driver, this);
	}

	public String getSearchText() {

		WebDriverWait wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(searchText));
		String textSearched = searchText.getText();
		return textSearched;

	}

}
