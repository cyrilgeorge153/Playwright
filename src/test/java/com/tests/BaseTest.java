package com.tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pages.HomePage;
import com.pages.LoginPage;

public class BaseTest {
	Playwright playwright;
	BrowserType firefox;
	BrowserType chromium;
	Browser browser;
	Page page;
	LoginPage loginPage;
	HomePage homePage;
	public static Logger logger;
	
	@BeforeClass
	public void generateLog() throws URISyntaxException {
		logger = Logger.getLogger("Utility");
		PropertyConfigurator.configure("./src/main/resources/log4j/log4j.properties");
	}
	
	@BeforeMethod
	public void setUp() {
		logger.info("starting setup");
		String browserName = System.getProperty("browsername"); 
		playwright = Playwright.create();
		chromium = playwright.chromium();
		firefox = playwright.firefox();
		if(browserName.equalsIgnoreCase("chrome"))
		{
			browser = chromium
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(1000));
		}
		else if(browserName.equalsIgnoreCase("headlesschrome"))
		{
			browser = chromium
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true).setSlowMo(1000));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			browser = firefox
					.launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(false).setSlowMo(1000));
		}
		else if(browserName.equalsIgnoreCase("headlessfirefox"))
		{
			browser = firefox
					.launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(true).setSlowMo(1000));
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			browser = chromium
					.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(1000));
		}
		else if(browserName.equalsIgnoreCase("headlessedge"))
		{
			browser = chromium
					.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(true).setSlowMo(1000));
		}
		else {
			System.out.println("browser not found");
		}
		page = browser.newPage();
		page.navigate("https://www.saucedemo.com/");
		loginPage=new LoginPage(page);
		homePage=new HomePage(page);
		logger.info("ending setup");
	}
	@AfterMethod
	public void tearDown()
	{
		logger.info("starting tearDown");
		browser.close();
		logger.info("ending tearDown");
	}
	@AfterSuite
    public static void openReport() {
        try {
            Desktop.getDesktop()
                    .browse(new File("test-output/index.html").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
