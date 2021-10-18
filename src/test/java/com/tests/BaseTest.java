package com.tests;

import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pages.HomePage;
import com.pages.LoginPage;

public class BaseTest {
	Playwright playwright;
	BrowserType firefox;
	BrowserType chromium;
	BrowserContext context;
	Browser browser;
	Page page;
	LoginPage loginPage;
	HomePage homePage;
	static Logger logger;

	@BeforeAll
	public static void generateLog() {
		logger = Logger.getLogger("Utility");
		PropertyConfigurator.configure("./src/main/resources/log4j/log4j.properties");
	}

	@BeforeEach
	public void setUp() {
		logger.info("starting setup");
		String browserName = System.getProperty("browsername");
		playwright = Playwright.create();
		chromium = playwright.chromium();
		firefox = playwright.firefox();
		if (browserName.equalsIgnoreCase("chrome")) {
			browser = chromium
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(1000));
		} else if (browserName.equalsIgnoreCase("headlesschrome")) {
			browser = chromium
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true).setSlowMo(1000));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			browser = firefox
					.launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(false).setSlowMo(1000));
		} else if (browserName.equalsIgnoreCase("headlessfirefox")) {
			browser = firefox
					.launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(true).setSlowMo(1000));
		} else if (browserName.equalsIgnoreCase("edge")) {
			browser = chromium
					.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(1000));
		} else if (browserName.equalsIgnoreCase("headlessedge")) {
			browser = chromium
					.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(true).setSlowMo(1000));
		} else {
			System.out.println("browser not found");
		}
		context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		page = context.newPage();
		page.navigate("https://www.saucedemo.com/");
		loginPage = new LoginPage(page);
		homePage = new HomePage(page);
		logger.info("ending setup");
	}

	@AfterEach
	public void tearDown() {
		logger.info("starting tearDown");
		context.close();
		browser.close();
		logger.info("ending tearDown");
	}
}
