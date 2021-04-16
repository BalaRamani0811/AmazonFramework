package com.mindtree.reusablecomponent;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverComponent {

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void enterText(String text, By element, WebDriver driver) {
		driver.findElement(element).sendKeys(text);
	}

	public void clickElement(By element, WebDriver driver) {
		driver.findElement(element).click();
	}

	public void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}

	public void clearText(By element, WebDriver driver) {
		driver.findElement(element).clear();
	}

	public void closeDriver(WebDriver driver) {
		driver.close();
	}

	public void quitDriver(WebDriver driver) {
		driver.quit();
	}

	public String getParentWindow(WebDriver driver) {
		String parent = driver.getWindowHandle();
		return parent;
	}

	public void switchWindows(String parent, WebDriver driver) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}
	}

	public void switchToParent(WebDriver driver, String parent) {
		driver.switchTo().window(parent);
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public WebElement returnElement(WebDriver driver, By element) {
		return driver.findElement(element);
	}
}
