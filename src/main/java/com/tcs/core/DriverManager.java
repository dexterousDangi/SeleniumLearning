package com.tcs.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

public static WebDriver getChromeDriver() {
	// System Property for Chrome Driver
	System.setProperty("webdriver.chrome.driver",
			"F:\\eclipse workspace\\selenium-demo\\src\\main\\resources\\drivers\\chromedriver.exe");

	// Instantiate a ChromeDriver class.
	WebDriver driver = new ChromeDriver();

	return driver;
}
	
}
