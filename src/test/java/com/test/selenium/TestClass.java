package com.test.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
	}

	@Test
	public void testLogin() {
		driver.findElement(By.id("email")).sendKeys("7838125667");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.id("loginbutton")).click();
	}

	public static void waitForElementTOAppear(WebDriver driver) throws InterruptedException {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id='addComment_1926331104077241']/div/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div")));
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = { "testLogin" })
	public void comment() throws InterruptedException {
		driver.get(
				"https://www.facebook.com/RHTDMMovie/photos/a.1506038219439867.1073741829.1161394927237533/1926331054077246/?type=3&theater");

		waitForElementTOAppear(driver);

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(
				"//*[@id='addComment_1926331104077241']/div/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div")))
				.click().build().perform();

		/*driver.findElement(By.xpath(
				"//*[@id=\"addComment_1926331104077241\"]/div/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div/span"))
				.click();*/
	}

}
