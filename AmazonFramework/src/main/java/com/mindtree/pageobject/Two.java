package com.mindtree.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.mindtree.reusablecomponent.DriverComponent;
import com.mindtree.uistore.TwoUi;
import com.mindtree.utility.TakeScreenShot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Two {

	DriverComponent dcomp = new DriverComponent();

	public void serachItem(WebDriver driver, Logger log4j, ExtentTest test, String item) {

		try {
			dcomp.implicitWait(driver);
			dcomp.clearText(TwoUi.searchBox, driver);
			dcomp.enterText(item, TwoUi.searchBox, driver);
			TakeScreenShot.takeElement(driver, TwoUi.cartIcon, "cartIcon");
			log4j.info(item + " Entered in SearchBox");
			test.log(LogStatus.PASS, item + " Entered in SearchBox");
		} catch (Exception e) {
			log4j.info("Failed To enter " + item + " in SearchBox");
			test.log(LogStatus.FAIL, "Failed To enter " + item + " in SearchBox");
		}

		try {
			dcomp.clickElement(TwoUi.search, driver);
			TakeScreenShot.takeElement(driver, TwoUi.searchBox, "searchButton");
			log4j.info(driver.getTitle());
			test.log(LogStatus.PASS, driver.getTitle());
			dcomp.implicitWait(driver);
			TakeScreenShot.takeOutput(driver, item);
			dcomp.navigateBack(driver);
		} catch (Exception e) {
			log4j.info("Failed to Searh Item " + item);
			test.log(LogStatus.FAIL, "Failed to Searh Item " + item);
		}
	}
}
