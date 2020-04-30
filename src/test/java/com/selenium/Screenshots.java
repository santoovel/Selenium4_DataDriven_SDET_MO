package com.selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {

	WebDriver driver;
	
	//@Test(description = "Taking screenshot of page")
	public void screenshotCompletePage() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("./Screenshots/HomePage.png");
		
		FileUtils.copyFile(srcFile, destFile);
		
		driver.close();
		
	}
	
	//@Test(description = "Screenshot of section of page")
	public void screenshotSepcificSectionOfPage() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement pageSection = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
		File srcFile = pageSection.getScreenshotAs(OutputType.FILE);
	
		
		File destFile = new File("./Screenshots/ProductFeatures.png");
		
		FileUtils.copyFile(srcFile, destFile);
		
		driver.close();
		
	}
	
	
	@Test(description = "Screenshot of an Web Element")
	public void ScreenshotOfWebElement() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement logoElement = driver.findElement(By.xpath("//div[@class='header-logo']//a//img"));
		
		highlightElement(logoElement,driver);
		
		File srcFile = logoElement.getScreenshotAs(OutputType.FILE);
	
		
		File destFile = new File("./Screenshots/logoElement.png");
		
		FileUtils.copyFile(srcFile, destFile);
		
		driver.close();
		
	}
	
	void highlightElement(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border=' 2px solid red'", ele);
		
	}
	

	
}
