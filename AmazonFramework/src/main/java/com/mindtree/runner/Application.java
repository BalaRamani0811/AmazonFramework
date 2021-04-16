package com.mindtree.runner;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mindtree.pageobject.One;
import com.mindtree.pageobject.Three;
import com.mindtree.pageobject.Two;
import com.mindtree.reusablecomponent.BrowserComponent;
import com.mindtree.reusablecomponent.DriverComponent;
import com.mindtree.utility.Excel;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.LogUtility;
import com.mindtree.utility.PropertyRead;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Application {

	public static Logger log4j;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	private ExtentReport reportUtility = new ExtentReport();
	private DriverComponent dcomp = new DriverComponent();
	private BrowserComponent bcomp = new BrowserComponent();
	private PropertyRead prop = new PropertyRead();
	private One one = new One();
	private Two two = new Two();
	private Three three = new Three();

	@DataProvider(name = "data")
	public static Object[][] data() {
		Object[][] items = Excel.readExcel();
		return items;
	}

	@DataProvider(name = "searchData")
	public static Iterator<String> inputItemData() {
		List<String> items = Excel.getItems();
		return items.iterator();
	}

	@BeforeSuite
	public void beforeSuite() {
		LogUtility.StartLogger();
		driver = bcomp.launchBrowser(log4j);
		dcomp.maximize(driver);
		reportUtility.startReport();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		reportUtility.startTest(extent, test, method);
	}

	@BeforeTest
	public void beforeTest() {
		try {
			dcomp.openUrl(driver, prop.getPropertyData("url"));
			log4j.info("Url Opened");
		} catch (Exception e) {
			e.printStackTrace();
			log4j.fatal("Failed to Open Url");
		}
		dcomp.implicitWait(driver);
	}
//
//	@Test(dataProvider = "data", priority = 1)
//	public void signIn(String username, String password) {
//		try {
//			one.SignIn(driver, log4j, test, username, password);
//			log4j.info("Login Test Passed");
//			test.log(LogStatus.PASS, "Login Test Passed");
//		} catch (Exception e) {
//			e.printStackTrace();
//			log4j.info("Login Test Failed");
//			test.log(LogStatus.FAIL, "Login Test Failed");
//		}
//	}
//
//	@Test(dataProvider = "searchData", priority = 2)
//	public void searchItems(String item) {
//		try {
//			two.serachItem(driver, log4j, test, item);
//			log4j.info("Search Item Test Passed");
//			test.log(LogStatus.PASS, "Search Test Passed");
//		} catch (Exception e) {
//			e.printStackTrace();
//			log4j.info("Search Item Test Failed");
//			test.log(LogStatus.FAIL, "Search Item Test Failed");
//		}
//	}

	@Test(priority = 3)
	public void addToCart() {
		try {
			three.addToCart(driver, log4j, test, prop.getPropertyData("itemName"));
			log4j.info("Add to Cart Test Passed");
			test.log(LogStatus.PASS, "Add to Cart Test Passed");
		} catch (Exception e) {
			log4j.info("Add to Cart Test Failed");
			test.log(LogStatus.PASS, "Add to Cart Test Failed");
		}
	}

	@AfterTest
	public void afterTest() {
		dcomp.closeDriver(driver);
		dcomp.quitDriver(driver);
	}

	@AfterMethod
	public void afterMethod() {
		reportUtility.endTest(test, extent);
	}

	@AfterSuite
	public void afterSuite() {
		reportUtility.flush(extent);
		reportUtility.closeReport(extent);
	}

}
