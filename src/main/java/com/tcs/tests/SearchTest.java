package com.tcs.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tcs.core.DriverManager;

public class SearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = DriverManager.getChromeDriver();

		driver.navigate().to("https://www.flipkart.com");

		driver.manage().window().maximize();
		
		WebElement emailInputBox = driver.findElement(By.cssSelector(
				"body > div._2Sn47c > div > div > div > div > div._36HLxm.col.col-3-5 > div > form > div:nth-child(1) > input"));
		emailInputBox.sendKeys("8750024099");

		Thread.sleep(1000);

		WebElement passwordbox = driver.findElement(By.cssSelector("input[type=password]"));
		passwordbox.sendKeys("Flipkart@123");
		Thread.sleep(1000);

		WebElement button = driver.findElement(By.cssSelector("button[type=submit] span"));
		button.click();

		Thread.sleep(3000);
		
		WebElement inputElement=driver.findElement(By.cssSelector("input[name=q]"));
		inputElement.sendKeys("nike Shoes");
		
		WebElement searchElement=driver.findElement(By.cssSelector("button[type=submit]"));
		searchElement.click();
		
		
		WebElement firstone= driver.findElement(By.cssSelector("#container > div > div._36fx1h._6t1WkM._3HqJxg > div._1YokD2._2GoDe3 > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1)"));
		firstone.click();
	}

}
