package com.selenium;

import java.util.List;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4Features {
	
	//@Test(priority=1)
	public void screenshotTest() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		File srcFile = logo.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/logo.png");
		FileUtils.copyFile(srcFile, destFile);
		driver.quit();
	}
	
	//@Test(priority=2)
	public void openNewWindow() throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		driver.quit();
	}
	
	//@Test(priority=3)
	public void openNewTab() throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		driver.quit();
	}
	
	//@Test(priority=4)
	public void Location() throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		
		System.out.println("Height: "+ logo.getRect().getDimension().getHeight());
		System.out.println("Width: "+ logo.getRect().getDimension().getWidth());
		
		System.out.println("X: " + logo.getRect().getX());
		System.out.println("Y: " + logo.getRect().getY());
		
		driver.quit();
		
	}
	
	
	
	//@Test(priority=5)
	public void switchTabs() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		String parent=driver.getWindowHandle();
		System.out.println("Parent Tab: "+ parent);
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		
		String childTab = driver.getWindowHandle();
		System.out.println("Child Tab: "+ childTab);
		
		newTab.get("http://www.google.com");
		
		newTab.findElement(By.name("q")).sendKeys("Selenium4 new Features");
		Thread.sleep(2000);
		newTab.close();
		
		driver.switchTo().window(parent);
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	//@Test(priority=6)
	public void RelativeLocators() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		WebElement btn=driver.findElement(RelativeLocator.withTagName("input").below(By.name("txtPassword")));
		btn.click();
	Thread.sleep(3000);
		driver.close();
		
		//also we can do 
		// import static org.openqa.selenium.support.locators.RelativeLocator.*;
		// WebElement btn=driver.findElement(withTagName("input").below(By.name("txtPassword")));
		
	}
	
	@Test(priority=7)
	public void verifySocialMediaiconsRelativeLocators() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//List<WebElement> socialAccount= driver.findElements(RelativeLocator.withTagName("img").below(By.xpath("//a[text()='OrangeHRM, Inc']")));
		
		List<WebElement> socialAccount  = driver.findElements(RelativeLocator.withTagName("img").below(By.xpath("//a[text()='OrangeHRM, Inc']")));
		System.out.println("Total count of socialAccount is :" + socialAccount.size());
		
		for(WebElement ele : socialAccount )
		{
			System.out.println("Alternate text is : "+ ele.getAttribute("alt"));
		}
		
		
		
		driver.quit();
	}

	// Relative locators in Selenium 4 are
	// above(), below(), near(). toLeftOf(), toRightOf()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
