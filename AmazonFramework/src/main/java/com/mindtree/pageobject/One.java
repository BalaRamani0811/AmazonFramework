package com.mindtree.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.mindtree.reusablecomponent.DriverComponent;
import com.mindtree.uistore.OneUi;
import com.mindtree.utility.TakeScreenShot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class One {

	DriverComponent dcomp = new DriverComponent();

	public void SignIn(WebDriver driver, Logger log4j, ExtentTest test, String username, String password) {

		try {
			TakeScreenShot.screenShotElement(driver, OneUi.sigIn, "SignIn");
			dcomp.clickElement(OneUi.sigIn, driver);
			log4j.info("Clicked SignIn button");
			test.log(LogStatus.PASS, "Clicked SignIn button Succesfully");
		} catch (Exception e) {
			log4j.info("Failed to Click SignIn button");
			test.log(LogStatus.FAIL, "Failed to Click SignIn button");
		}

		try {
			dcomp.enterText(username, OneUi.username, driver);
			log4j.info("Username Entered");
			test.log(LogStatus.PASS, "Username Entered Succesfully");
		} catch (Exception e) {
			log4j.info("Failed to enter Username");
			test.log(LogStatus.FAIL, "Failed to enter Username");
		}

		try {
			dcomp.clickElement(OneUi.next, driver);
			log4j.info("Clicked Continue button");
			test.log(LogStatus.PASS, "Clicked Continue button Succesfully");
		} catch (Exception e) {
			log4j.info("Failed to Click Continue button");
			test.log(LogStatus.FAIL, "Failed to Click Continue button");
		}

		try {
			dcomp.enterText(password, OneUi.password, driver);
			log4j.info("Password Entered");
			test.log(LogStatus.PASS, "Password Entered Succesfully");
		} catch (Exception e) {
			log4j.info("Failed to enter Password");
			test.log(LogStatus.FAIL, "Failed to enter Password");
		}

		try {
			dcomp.clickElement(OneUi.proceed, driver);
			log4j.info("Clicked sign-In button");
			test.log(LogStatus.PASS, "Clicked sign-In button Succesfully");
		} catch (Exception e) {
			log4j.info("Failed to Click sign-In button");
			test.log(LogStatus.FAIL, "Failed to Click sign-In button");
		}

	}
}
