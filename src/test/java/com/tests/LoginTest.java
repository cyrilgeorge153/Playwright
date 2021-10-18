package com.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("Login Tests Epic")
@Feature("Valid Login Test Features")
@Execution(ExecutionMode.CONCURRENT)
public class LoginTest extends BaseTest {

	@Test
	@Story("verifyLoginPageTitleTest Story")
    @Description("verifyLoginPageTitleTest Description")
	public void verifyLoginPageTitleTest() {
		logger.info("starting test case verifyLoginPageTitleTest");
		Assertions.assertEquals(loginPage.verifyLoginPageTitle(), "Swag Labs");
		logger.info("ending test case verifyLoginPageTitleTest");
	}

	@Test
	@Story("verifyLoginButtonTest Story")
    @Description("verifyLoginButtonTest Description")
	public void verifyLoginButtonTest() {
		logger.info("starting test case verifyLoginButtonTest");
		Assertions.assertEquals(loginPage.verifyLoginButton(), true);
		logger.info("ending test case verifyLoginButtonTest");
	}
}
