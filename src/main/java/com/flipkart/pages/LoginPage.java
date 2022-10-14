package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class LoginPage extends Base {

	// Object repository:

	@FindBy(xpath = "//input[@type='text' and @class = '_2IX_2- VJZDxU']")
	WebElement usernameField;

	@FindBy(xpath = "//input[@type='password' and @class = '_2IX_2- _3mctLh VJZDxU']")
	WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit' and @class = '_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement closeBtn;

	// Initialize page objects:

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public String getLoginPageTitle() {

		String loginPageTitle = driver.getTitle();
		return loginPageTitle;

	}

	public HomePage login(String Un, String Pwd) throws Throwable {
		usernameField.sendKeys(Un);
		passwordField.sendKeys(Pwd);
		loginBtn.click();
		return new HomePage();

	}

	public void closeLoginPopup() {
		closeBtn.click();
	}

}
