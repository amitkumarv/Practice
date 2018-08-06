package com.test.selenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.get("file:///D:/workspace/Practice/testdata/JQueryTimer.html");
		driver.findElement(By.cssSelector("button")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		final String xpath = ".//div[text()='Your text here10']";

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				/*
				 * WebElement elem = driver.findElement(By.id("div1")); String str =
				 * elem.getText(); System.out.println(str);
				 */
				return driver.findElement(By.xpath(xpath));
			}
		});
		
		ArrayList<String> al = (ArrayList<String>) driver.getWindowHandles();
		
	}

}
