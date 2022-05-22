package com.tcs.tests;


import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tcs.core.DriverManager;

public class FlipkartAddToCartFlow {

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
	
		
		Set<String> listofelement = driver
				.findElements(By.cssSelector("#container > div > div._331-kn._2tvxW > div > div div")) 
				.stream()
				.map(element -> element.getAttribute("innerText"))
				.collect(Collectors.toSet());

		System.out.println(listofelement);

//          LinkedHashSet<String> uniqueelement=new LinkedHashSet<>();
//          for(WebElement str: listofelement) {
//				uniqueelement.add(str.getAttribute("innerText"));
//			}
		// System.out.println(uniqueelement);

		Thread.sleep(1000);

	}

}
