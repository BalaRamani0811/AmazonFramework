package com.mindtree.utility;

import java.lang.reflect.Method;

import com.mindtree.runner.Application;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {

	public void startReport() {
		Application.extent = new ExtentReports(
				".//extent-reports//" + System.getProperty("current.dateTime") + "_AmazonTestReport.html");
	}

	public void startTest(ExtentReports extent, ExtentTest test, Method method) {
		Application.test = extent.startTest(method.getName());
	}

	public void endTest(ExtentTest test, ExtentReports extent) {
		extent.endTest(test);
	}

	public void flush(ExtentReports extent) {
		extent.flush();
	}

	public void closeReport(ExtentReports extent) {
		extent.close();
	}
}
