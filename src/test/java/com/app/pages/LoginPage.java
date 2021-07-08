package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.utils.DriverHelper;

public class LoginPage extends DriverHelper {

	// ==================Login screen locators========================

	@FindBy(xpath = "//li[@class='nav-button']/a[contains(text(),'Log in')]")
	private WebElement loginButtonAtHomeScreen;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "logIn")
	private WebElement loginButton;

	@FindBy(className = "hui-globaluseritem")
	private WebElement profileDisplayName;

	@FindBy(xpath = "//div[@class='hui-globalusermenu__items']//div[contains(@class,'hui-globaladditionalitems')]//a//span[contains(text(),'Log Out')]")
	private WebElement logoutLink;

	@FindBy(xpath = "//a[@data-qa-id='webnav-globalnav-home']")
	private WebElement HomeMenu;

	@FindBy(xpath = "//div[@class='login-error-container']//p")
	private WebElement loginErrorMessage;

	@FindBy(id = "forgot-password-link")
	private WebElement needHelpLink;

	@FindBy(id = "forgot-email")
	private WebElement forgotEmailAddress;

	@FindBy(id = "resetBtn")
	private WebElement sendPasswordResetButton;

	@FindBy(xpath = "//form[@class='reset-sent-container']//div[@class='reset-info']")
	private WebElement forgotPasswordResetMessage;

	// ================================================================

	public LoginPage(WebDriver webdriver) {
		super(webdriver);

	}

	public LoginPage clickOnLoginButtonAtHomeScreen() {
		loginButtonAtHomeScreen.click();
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public LoginPage enterEmailAddress(String emailAddress) {
		emailField.clear();
		emailField.sendKeys(emailAddress);
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public LoginPage enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public LoginPage clickOnLoginButton() throws InterruptedException {
		loginButton.click();
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public LoginPage clickOnProfileDisplayName() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("hui-globaluseritem")));
		profileDisplayName.click();
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public LoginPage clickOnlogoutLink() {
		logoutLink.click();
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public boolean isHomeMenuDisplayed() {
		return HomeMenu.isDisplayed();
	}

	public String getLoginErrorMessage() throws InterruptedException {
		WaitUntilWebElementIsVisible(loginErrorMessage);
		return loginErrorMessage.getText();
	}

	public LoginPage clickOnNeedHelpLink() {
		needHelpLink.click();
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public LoginPage enterForgotEmailAddress(String forgotmailAddress) {
		forgotEmailAddress.clear();
		forgotEmailAddress.sendKeys(forgotmailAddress);
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public LoginPage clickOnSendPasswordResetButton() {
		sendPasswordResetButton.click();
		return PageFactory.initElements(getWebDriver(), LoginPage.class);
	}

	public String getForgotPasswordResetMessage() throws InterruptedException {
		WaitUntilWebElementIsVisible(forgotPasswordResetMessage);
		return forgotPasswordResetMessage.getText();
	}

}
