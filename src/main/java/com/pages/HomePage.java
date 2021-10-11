package com.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	private final Page page;
	private String products_css = ".title";
	private String cart_css=".shopping_cart_link";
	
	public HomePage(Page page) {
		this.page = page;
	}
	
	public String verifyProductsHeading() {
		return page.locator(products_css).textContent();
	}
	
	public boolean verifyCartButton() {
		return page.locator(cart_css).isVisible();
	}

}
