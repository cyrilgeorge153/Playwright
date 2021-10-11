package com.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private final Page page;
	private String username_id = "id=user-name";
	private String password_id = "id=password";
	private String login_button_id = "id=login-button";

	public LoginPage(Page page) {
		this.page = page;
	}

	public String verifyLoginPageTitle() {
		return page.title();
	}

	public boolean verifyLoginButton() {
		return page.locator(login_button_id).isVisible();		
	}
	
	public void loginApp()
	{
		page.locator(username_id).fill("standard_user");
		page.locator(password_id).fill("secret_sauce");
		page.locator(login_button_id).click();
	}
	

}
