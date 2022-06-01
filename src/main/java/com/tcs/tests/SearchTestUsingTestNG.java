package com.tcs.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tcs.core.DriverManager;

public class SearchTestUsingTestNG {
	
	WebDriver driver=null;
	
	@BeforeMethod
	public void setup() {
		driver = DriverManager.getChromeDriver();
		
		driver.navigate().to("https://www.flipkart.com");

		driver.manage().window().maximize();

	
	}
	
	@Test
	public void testOne() {
		
		System.out.println(driver.getTitle());
	}

	@Test
	public void testTwo() {
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void a() {
		System.out.println(driver.getTitle());
	}

	@Test
	public void bb() {
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void getMe() {
		driver.quit();
	}
	
}
