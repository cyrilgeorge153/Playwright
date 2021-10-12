package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{
	@Test(priority = 2)
	public void verifyProductsHeadingTest() {
		logger.info("starting test case verifyProductsHeadingTest");
		loginPage.loginApp();
		Assert.assertEquals(homePage.verifyProductsHeading(), "Products");
		logger.info("ending test case verifyProductsHeadingTest");
	}
	@Test(priority = 3)
	public void verifyCartButtonTest() {
		logger.info("starting test case verifyCartButtonTest");
		loginPage.loginApp();
		Assert.assertEquals(homePage.verifyCartButton(), true);
		logger.info("ending test case verifyCartButtonTest");
	}

}
