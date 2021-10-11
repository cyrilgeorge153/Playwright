package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{
	@Test(priority = 2)
	public void verifyProductsHeadingTest() {
		loginPage.loginApp();
		Assert.assertEquals(homePage.verifyProductsHeading(), "Products");
	}
	@Test(priority = 3)
	public void verifyCartButtonTest() {
		loginPage.loginApp();
		Assert.assertEquals(homePage.verifyCartButton(), true);
	}

}
