package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class HomePage extends Base {

	// Home Page - Page Factory:

	@FindBy(xpath = "//a[contains(text(), 'Login')]")
	WebElement loginBTN;

	@FindBy(xpath = "//input[@class='_3704LK']")
	WebElement searchBox;

	@FindBy(xpath = "//button[@type='submit' and @class='L0Z3Pu']")
	WebElement submitBtn;

	// Initialize Homepage objects:

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	// HomePage Actions:

	public boolean getLoginButton() {

		boolean flag = loginBTN.isDisplayed();
		return flag;

	}

	public SearchResultPage productSearch(String productName) {

		Actions actions = new Actions(driver);
		actions.sendKeys(searchBox, productName).build().perform();
		submitBtn.click();
		return new SearchResultPage();

	}

}
