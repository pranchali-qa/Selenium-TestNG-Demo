package com.example.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

    public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='email']")
	private WebElement userName;

	public void enterUserName(String username, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys(username);
	}

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	public void enterPassword(String passwordValue, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(passwordValue);
	}

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement signInBtn;

	public void clickOnSignInBtn(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(signInBtn)).click();
	}

}
