package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	
	// Relative locators in Selenium 4 are
		// above(), below(), near(). toLeftOf(), toRightOf()
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationbookstore.dev/");
		
	}
	
	// Test Book 5 is left of Book6 and below Book 1
	
	@Test(description = "Test Book 5 is left of Book6 and below Book 1")
	public void test1() {
		WebElement book5 = driver.findElement(RelativeLocator.withTagName("li").toLeftOf(By.id("pid6")).below(By.id("pid1")));
		String id = book5.getAttribute("id");
		System.out.println("Book Id is: " + id);
		Assert.assertEquals("pid5", id);
	}
	
	//Test Book2 is above Book 6 and right of Book 1
	@Test(description = " Book2 is above Book 6 and right of Book 1")
	public void test2() {

		WebElement book2 = driver.findElement(RelativeLocator.withTagName("li").toRightOf(By.id("pid1")).above(By.id("pid6")));
		String id1 = book2.getAttribute("id");
		System.out.println("Book Id1 is: "+ id1);
		Assert.assertEquals("pid2", id1);
		
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
}
