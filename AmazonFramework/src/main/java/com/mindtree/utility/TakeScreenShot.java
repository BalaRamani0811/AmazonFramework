package com.mindtree.utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.reusablecomponent.DriverComponent;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakeScreenShot {

	static DriverComponent dcomp = new DriverComponent();

	public static void takeOutput(WebDriver driver, String item) {
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,
					new File(".//screenshots//" + System.getProperty("current.dateTime") + " " + item + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void takeElement(WebDriver driver, By element, String name) {
		try {
			WebElement web = dcomp.returnElement(driver, element);
			File f = web.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f,
					new File(".//elementscreenshots//" + System.getProperty("current.dateTime") + " " + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ashotScreenShot(WebDriver driver, String name) {
		try {
			Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1500))
					.takeScreenshot(driver);
			ImageIO.write(s.getImage(), "PNG",
					new File(".//elementscreenshots//" + System.getProperty("current.dateTime") + " " + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void screenShotElement(WebDriver driver, By element, String name) {
		WebElement logo = dcomp.returnElement(driver, element);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			BufferedImage fullScreen = ImageIO.read(screenshot);
			Point location = logo.getLocation();
			int width = logo.getSize().getWidth();
			int height = logo.getSize().getHeight();
			BufferedImage logoImage = fullScreen.getSubimage(location.getX(), location.getY(), width, height);
			ImageIO.write(logoImage, "png", screenshot);
			FileUtils.copyFile(screenshot,
					new File(".//elementscreenshots//" + System.getProperty("current.dateTime") + " " + name + ".png"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
