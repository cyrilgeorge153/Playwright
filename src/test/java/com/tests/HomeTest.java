package com.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("Home Tests Epic")
@Feature("Valid Home Test Features")
@Execution(ExecutionMode.CONCURRENT)
public class HomeTest extends BaseTest{
	
	@Test
	@Story("verifyProductsHeadingTest Story")
    @Description("verifyProductsHeadingTest Description")
	public void verifyProductsHeadingTest() {
		logger.info("starting test case verifyProductsHeadingTest");
		loginPage.loginApp();
		Assertions.assertEquals(homePage.verifyProductsHeading(), "Products");
		logger.info("ending test case verifyProductsHeadingTest");
	}
	
	@Test
	@Story("verifyCartButtonTest Story")
    @Description("verifyCartButtonTest Description")
	public void verifyCartButtonTest() {
		logger.info("starting test case verifyCartButtonTest");
		loginPage.loginApp();
		Assertions.assertEquals(homePage.verifyCartButton(), true);
		logger.info("ending test case verifyCartButtonTest");
	}
}
