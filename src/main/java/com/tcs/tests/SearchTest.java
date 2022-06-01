package com.tcs.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tcs.core.DriverManager;

public class SearchTest {

	public static String refineRawPrice(String rawPrice) {

		String newraw = "";
		for (int i = 0; i < rawPrice.length(); i++) {
			char ch = rawPrice.charAt(i);
			if (ch >= '0' && ch <= '9') {
				newraw = newraw + ch;
			}
		}
		return newraw;
	}

	public static Map<String, String> allSizeAndTheirPrice() throws InterruptedException {

		HashMap<String, String> mapAllPrice = new HashMap<>();

		String sizeInnerText = "a._1fGeJ5._2UVyXR._31hAvz";
		String shoepriceSelector = " div._30jeq3._16Jk6d";
//		driver.findElements(By.cssSelector(sizeInnerText)).forEach(sizeLink -> {
//			String sizeKey= sizeLink.getAttribute("innerText").trim();
//			sizeLink.click();
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			String shoePrice = driver.findElement(By.cssSelector(shoepriceSelector)).getText();
//			mapAllPrice.put(sizeKey, shoePrice);
//		 }) ;     
//		
//		 
//	return mapAllPrice;
//	}
	
		int sizeList=driver.findElements(By.cssSelector(sizeInnerText)).size();
		System.out.println("size avialable: " + sizeList);
		for (int i = 0; i < sizeList; i++) {
			List<WebElement> element = driver.findElements(By.cssSelector(sizeInnerText));
			WebElement element2 = element.get(i);
			String size = element2.getAttribute("innerText");
			element2.click();
			Thread.sleep(3000);
			WebElement shoeRawPrice = driver.findElement(By.cssSelector(shoepriceSelector));
			String rawPrice = shoeRawPrice.getText();
			String newraw = refineRawPrice(rawPrice);
			Thread.sleep(3000);
			mapAllPrice.put(size, newraw);

		}
		return mapAllPrice;
	}

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		
		driver = DriverManager.getChromeDriver();

		driver.navigate().to("https://www.flipkart.com");

		driver.manage().window().maximize();

		WebElement emailInputBox = driver
				.findElement(By.cssSelector("div.col-3-5 > div > form > div:nth-child(1) > input"));
		emailInputBox.sendKeys("8750024099");

		Thread.sleep(1000);

		WebElement passwordbox = driver.findElement(By.cssSelector("input[type=password]"));
		passwordbox.sendKeys("Flipkart@123");
		Thread.sleep(1000);

		WebElement button = driver.findElement(By.cssSelector("button[type=submit] span"));
		button.click();

		Thread.sleep(2000);

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
		String shoeSizeSelector = "div:nth-child(2) > div._22QfJJ > ul li[id]";
		List<WebElement> element = driver.findElements(By.cssSelector(shoeSizeSelector));
		WebElement element2 = element.get(3);
		element2.click();
		Thread.sleep(3000);

		System.out.println(allSizeAndTheirPrice());

		WebElement shoeRawPrice = driver.findElement(By.cssSelector(" div._30jeq3._16Jk6d"));
		String rawPrice = shoeRawPrice.getText();
		String newraw = refineRawPrice(rawPrice);

		Integer price = Integer.parseInt(newraw);
		System.out.println("price of one pair of shoes: " + price);
		Thread.sleep(2000);

		driver.findElement(By.cssSelector(" ul > li:nth-child(1) > button > svg")).click();

		Thread.sleep(2000);
		WebElement increaseCount = driver.findElement(By.cssSelector("div._1uc2IE > div > button:nth-child(3)"));
		increaseCount.click();

		Thread.sleep(3000);
		String totalAmount = driver.findElement(By.cssSelector(" div._3LxTgx > div > span > div > div > span"))
				.getText();
		String refinedTotal = refineRawPrice(totalAmount);
		Integer totalprice = Integer.parseInt(refinedTotal);
		System.out.println("price of two pair fo shoes: " + totalprice);
//
//		WebElement placeOrder = driver.findElement(By.cssSelector("button._2KpZ6l._2ObVJD._3AWRsL"));
//		placeOrder.click();

	}

}
