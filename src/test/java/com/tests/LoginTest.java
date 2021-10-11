package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	
	@Test(priority = 0)
	public void verifyLoginPageTitleTest() {		
       Assert.assertEquals(loginPage.verifyLoginPageTitle(), "Swag Labs");
	}
	@Test(priority = 1)
	public void verifyLoginButtonTest() {
		Assert.assertEquals(loginPage.verifyLoginButton(), true);
	}
	
//	@Test(priority = 2)
	public void verifyLoginTest() {
		loginPage.loginApp();
	}
	
	
}
