package com.tcs.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AnnotationsTest {
  @Test
  @Parameters({"browser"})
  public void testMethod1(String browser) {
	  
	  System.out.println("Annotation test 1 test method1 "+browser);
  }
  @Test
  public void testMethod2() {
	  System.out.println("test method2");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void afterMethod() { 
	  System.out.println("after Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before Test");
  }

  @AfterTest
  public void afterTest() { 
	  System.out.println("after Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after Suite");
  }

}
