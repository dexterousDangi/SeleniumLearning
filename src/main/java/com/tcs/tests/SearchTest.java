package com.tcs.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tcs.core.DriverManager;

public class SearchTest {
	static WebDriver driver = null;

	public static void getSizeAndPrice(List<WebElement> allsize) throws InterruptedException {
		WebElement element=allsize.get(0);
		element.click();
		Thread.sleep(1500);

		WebElement shoeRawPrice = driver.findElement(By.cssSelector(" div._30jeq3._16Jk6d"));
		String rawPrice = shoeRawPrice.getText();

		Integer price = Integer.parseInt(rawPrice.substring(1));
		System.out.println("price of one pair of shoes: " + price);
		
//		Thread.sleep(3000);
		//int availablesizes = allsize.size();
//		HashMap<Integer, Integer> priceDetails = new HashMap<>();
//		for (int i = 1; i < allsize.size(); i++) {
//			allsize.get(i).click();
//			Thread.sleep(3000);
//
//			WebElement shoeRawPrice1 = driver.findElement(By.cssSelector(" div._30jeq3._16Jk6d"));
//			String rawPrice1 = shoeRawPrice1.getText();
//
//			Integer price1 = Integer.parseInt(rawPrice1.substring(1));
//			priceDetails.put(i, price1);
//		}
//		System.out.println(priceDetails);
	}

	public static void main(String[] args) throws InterruptedException {

		driver = DriverManager.getChromeDriver();

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

		Thread.sleep(5000);

		WebElement inputElement = driver.findElement(By.cssSelector("input[name=q]"));
		inputElement.sendKeys("puma shoe");

		WebElement searchElement = driver.findElement(By.cssSelector("button[type=submit]"));
		searchElement.click();

		Thread.sleep(3000);

		List<WebElement> firstone = driver.findElements(By.cssSelector("a[class=_2UzuFa]"));
		firstone.get(0).click();

		Thread.sleep(3000);

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		Thread.sleep(1000);

		// TODO create a method
		List<WebElement> shoesize = driver.findElements(By.cssSelector("div:nth-child(2) > div._22QfJJ > ul li[id]"));
		shoesize.get(0).click();
		Thread.sleep(1500);

		WebElement shoeRawPrice = driver.findElement(By.cssSelector(" div._30jeq3._16Jk6d"));
		String rawPrice = shoeRawPrice.getText();
		System.out.println(rawPrice);
		String newraw="";
				for(int i=0;i<rawPrice.length();i++) {
					char ch=rawPrice.charAt(i);
					if(ch>='0'&&ch<='9') {
						newraw=newraw+ch;
					}
				}
				System.out.println(newraw);
//		Integer price = Integer.parseInt(newraw);
//		System.out.println("price of one pair of shoes: " + price);
//		
		
		Thread.sleep(2000);		
		 driver.findElement(By.cssSelector(" ul > li:nth-child(1) > button > svg")).click();
		 
		 Thread.sleep(2000);
		 WebElement increaseCount= driver.findElement(By.cssSelector("div._1uc2IE > div > button:nth-child(3)"));
		 increaseCount.click();
		 
		 Thread.sleep(3000);
		 String totalAmount= driver.findElement(By.cssSelector(" div._3LxTgx > div > span > div > div > span")).getText();
		 System.out.println(totalAmount);
		 
		 
	}

}
