package com.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
@Execution(ExecutionMode.CONCURRENT)
public class HomeTest extends BaseTest{
	@Test
	public void verifyProductsHeadingTest() {
		logger.info("starting test case verifyProductsHeadingTest");
		loginPage.loginApp();
		Assertions.assertEquals(homePage.verifyProductsHeading(), "Products");
		logger.info("ending test case verifyProductsHeadingTest");
	}
	@Test
	public void verifyCartButtonTest() {
		logger.info("starting test case verifyCartButtonTest");
		loginPage.loginApp();
		Assertions.assertEquals(homePage.verifyCartButton(), true);
		logger.info("ending test case verifyCartButtonTest");
	}

}
