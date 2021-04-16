package com.mindtree.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.mindtree.reusablecomponent.DriverComponent;
import com.mindtree.uistore.ThreeUi;
import com.mindtree.utility.TakeScreenShot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Three {

	DriverComponent dcomp = new DriverComponent();

	public void addToCart(WebDriver driver, Logger log4j, ExtentTest test, String item) {

		try {
			dcomp.implicitWait(driver);
			dcomp.enterText(item, ThreeUi.searchBox, driver);
			log4j.info(item + " is Entered");
			test.log(LogStatus.PASS, item + " is Entered");
		} catch (Exception e) {
			log4j.info("Failed To enter " + item + " in SearchBox");
			test.log(LogStatus.FAIL, "Failed To enter " + item + " in SearchBox");
		}

		try {
			dcomp.clickElement(ThreeUi.search, driver);
			log4j.info("Search Button is Clicked");
			test.log(LogStatus.PASS, "Search Button is Clicked");
		} catch (Exception e) {
			log4j.info("Failed to Searh Item " + item);
			test.log(LogStatus.FAIL, "Failed to Searh Item " + item);
		}

		String parent = null;

		try {
			parent = dcomp.getParentWindow(driver);
			dcomp.clickElement(ThreeUi.itemName, driver);
			log4j.info("Switched to Product window");
			test.log(LogStatus.PASS, "Switched to Product window");
		} catch (Exception e) {
			log4j.info("Failed to Switch to Product window");
			test.log(LogStatus.FAIL, "Failed to Switch to Product window");
		}

		try {
			dcomp.switchWindows(parent, driver);
			dcomp.clickElement(ThreeUi.cart, driver);
			dcomp.refreshPage(driver);
			TakeScreenShot.takeElement(driver, ThreeUi.updatedCart, "UpdatedCart");
			log4j.info("Add to cart button is Clicked");
			test.log(LogStatus.PASS, "Add to cart button is Clicked");
		} catch (Exception e) {
			log4j.info("Failed to Click Add to cart Button");
			test.log(LogStatus.FAIL, "Failed to Click Add to cart Button");
		}

		try {
			dcomp.switchToParent(driver, parent);
			dcomp.refreshPage(driver);
			dcomp.implicitWait(driver);
			Thread.sleep(10000);
			log4j.info("Navigated Back to parent Window");
			test.log(LogStatus.PASS, "Navigated Back to parent Window");
		} catch (Exception e) {
			log4j.info("Failed To Navigate Back to parent Window");
			test.log(LogStatus.PASS, "Failed To Navigate Back to parent Window");
		}
	}

}
