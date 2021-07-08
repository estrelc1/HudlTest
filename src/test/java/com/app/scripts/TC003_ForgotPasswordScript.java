package com.app.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.utils.DriverTestCase;

public class TC003_ForgotPasswordScript extends DriverTestCase {

	@Test
	public void ForgotPasswordTest() throws InterruptedException {

		// click on login button at home screen
		loginPage.clickOnLoginButtonAtHomeScreen();

		// click on need help button
		loginPage.clickOnNeedHelpLink();

		// enter email address
		String emailAddress = propertyReader.readApplicationFile("EmailAddress");
		loginPage.enterForgotEmailAddress(emailAddress);

		// click on send password reset button
		loginPage.clickOnSendPasswordResetButton();

		// click on send password reset button
		String resetPasswordMessage = loginPage.getForgotPasswordResetMessage();
		// verify that reset message after sending the forgot password email
		Assert.assertTrue(resetPasswordMessage.contains("Check Your Email"));

	}

}
