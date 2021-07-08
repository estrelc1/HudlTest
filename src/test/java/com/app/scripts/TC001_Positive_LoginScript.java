package com.app.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.utils.DriverTestCase;

public class TC001_Positive_LoginScript extends DriverTestCase {

	
	@Test
	public void LoginPositiveTest() throws InterruptedException {

		// click on login button at home screen
		loginPage.clickOnLoginButtonAtHomeScreen();

		// enter email address
		String emailAddress = propertyReader.readApplicationFile("EmailAddress");
		loginPage.enterEmailAddress(emailAddress);

		// enter password address
		String password = propertyReader.readApplicationFile("Password");
		loginPage.enterPassword(password);

		// click on login button
		loginPage.clickOnLoginButton();

		// verify after login home menu should be displayed
		boolean result = loginPage.isHomeMenuDisplayed();
		Assert.assertTrue(result, "Home button should be displayed after successfully login");

		// click on profile display name
		loginPage.clickOnProfileDisplayName();

		// click on logout link
		loginPage.clickOnlogoutLink();

	}

}
