package com.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class LoginTest extends BaseTest {

	@Test
	public void verifyLoginPageTitleTest() {
		logger.info("starting test case verifyLoginPageTitleTest");
		Assertions.assertEquals(loginPage.verifyLoginPageTitle(), "Swag Labs");
		logger.info("ending test case verifyLoginPageTitleTest");
	}

	@Test
	public void verifyLoginButtonTest() {
		logger.info("starting test case verifyLoginButtonTest");
		Assertions.assertEquals(loginPage.verifyLoginButton(), true);
		logger.info("ending test case verifyLoginButtonTest");
	}
}
