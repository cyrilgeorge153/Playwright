package com.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	public static Logger logger;

	@BeforeAll
	public static void generateLog() throws IOException  {
		logger = LogManager.getLogger(BaseTest.class);
		logger.info("starting deleteAllureResults");
		Files.walk(Paths.get(System.getProperty("user.dir")+"/allure-results/"))
        .filter(Files::isRegularFile)
        .map(Path::toFile)
        .forEach(File::delete);
		logger.info("ending deleteAllureResults");
	}
	
	@BeforeEach
	public void setUp() {
		logger.info("starting setup");
		String browserName = System.getProperty("browsername","chrome");
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
