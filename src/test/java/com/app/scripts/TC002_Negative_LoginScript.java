package com.app.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.utils.DriverTestCase;

public class TC002_Negative_LoginScript extends DriverTestCase {

	@Test
	public void LoginNegativeTest() throws InterruptedException {

		// click on login button at home screen
		loginPage.clickOnLoginButtonAtHomeScreen();

		// enter email address
		String emailAddress = propertyReader.readApplicationFile("EmailAddress");
		loginPage.enterEmailAddress(emailAddress);

		// enter Wrong Password address
		String password = propertyReader.readApplicationFile("WrongPassword");
		loginPage.enterPassword(password);

		// click on login button
		loginPage.clickOnLoginButton();

		String loginErrorMessage = loginPage.getLoginErrorMessage();
		// verify that error message should be displayed after providing incorrect
		// credential
		Assert.assertTrue(loginErrorMessage.contains("We didn't recognize that email and/or password"));

	}

}
