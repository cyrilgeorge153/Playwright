package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pages.HomePage;
import com.pages.LoginPage;

public class BaseTest {
	Playwright playwright;
	BrowserType chrome;
	Browser browser;
	Page page;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		String browserName = System.getProperty("browsername"); 
		if(browserName.equalsIgnoreCase("chrome"))
		{
			playwright = Playwright.create();
			chrome = playwright.chromium();
			browser = chrome
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(1000));
			page = browser.newPage();
			page.navigate("https://www.saucedemo.com/");
			loginPage=new LoginPage(page);
			homePage=new HomePage(page);
		}
		else if(browserName.equalsIgnoreCase("headlesschrome"))
		{
			playwright = Playwright.create();
			chrome = playwright.chromium();
			browser = chrome
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true).setSlowMo(1000));
			page = browser.newPage();
			page.navigate("https://www.saucedemo.com/");
			loginPage=new LoginPage(page);
			homePage=new HomePage(page);
		}
		else {
			System.out.println("browser not found");
		}
		
	}
	@AfterMethod
	public void tearDown()
	{
		browser.close();
	}

}
