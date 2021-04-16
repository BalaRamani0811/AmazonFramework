package com.mindtree.reusablecomponent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserComponent {

	public static WebDriver driver;

	public WebDriver launchBrowser(Logger log4j) {
		System.setProperty("webdriver.chrome.driver", ".//driver//chrome//chromedriver.exe");
		System.setProperty("org.freemarker.loggerLibrary", "none");
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			log4j.info("Browser Opened");
		} catch (Exception e) {
			log4j.fatal("Failed to Open Browser");
		}
		return driver;
	}
}
