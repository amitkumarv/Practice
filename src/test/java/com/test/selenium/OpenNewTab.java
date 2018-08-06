package com.test.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenNewTab {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.get("https://paytm.com/");

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		// Using javascript executor
		/*
		 * JavascriptExecutor jsx = (JavascriptExecutor)driver;
		 * jsx.executeScript("window.open('https://mail.google.com');");
		 * Thread.sleep(10000); ArrayList<String> tabs = new
		 * ArrayList<String>(driver.getWindowHandles());
		 * driver.switchTo().window(tabs.get(1));
		 * System.out.println(driver.getCurrentUrl());
		 */

		// Using Robot class
		/*
		 * Robot r = new Robot(); r.keyPress(KeyEvent.VK_CONTROL);
		 * r.keyPress(KeyEvent.VK_T); r.keyRelease(KeyEvent.VK_CONTROL);
		 * r.keyRelease(KeyEvent.VK_T); //Thread.sleep(10000); ArrayList<String> tabs1 =
		 * new ArrayList<String>(driver.getWindowHandles());
		 * driver.switchTo().window(tabs1.get(1));
		 */
		// driver.get("https://stackoverflow.com");

		// Using Actions class
		/*
		 * Actions act = new Actions(driver);
		 * act.keyDown(Keys.CONTROL).sendKeys(driver.findElement(By.xpath(
		 * "//*[@id='nav-jobs']")), "t").build().perform();
		 */

	}

	@Test()
	public void testMethod() {
		SoftAssert softAssert = new SoftAssert();

		// Assertion failing
		softAssert.fail();
		System.out.println("Failing");

		// Assertion passing
		softAssert.assertEquals(1, 1);
		System.out.println("Passing");

		// Collates test results and marks them pass or fail
		softAssert.assertAll();
	}

}
