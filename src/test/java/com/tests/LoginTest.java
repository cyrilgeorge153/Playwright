package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test(priority = 0)
	public void verifyLoginPageTitleTest() {
		logger.info("starting test case verifyLoginPageTitleTest");
		Assert.assertEquals(loginPage.verifyLoginPageTitle(), "Swag Labs");
		logger.info("ending test case verifyLoginPageTitleTest");
	}

	@Test(priority = 1)
	public void verifyLoginButtonTest() {
		logger.info("starting test case verifyLoginButtonTest");
		Assert.assertEquals(loginPage.verifyLoginButton(), true);
		logger.info("ending test case verifyLoginButtonTest");
	}
}
