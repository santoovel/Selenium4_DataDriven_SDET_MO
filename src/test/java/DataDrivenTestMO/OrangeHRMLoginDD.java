package DataDrivenTestMO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.ExcelDataConfig;

public class OrangeHRMLoginDD {

	WebDriver driver;
	
	@Test(dataProvider="OrangeHrmData")
	public void loginToWordPress(String username, String password) throws Exception{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//driver.get("https://demosite.center/wordpress/wp-login.php");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		Thread.sleep(5000);
		
		//System.out.println("Title is :"+ driver.getTitle());
		
	       // WebElement ele=driver.findElement(By.xpath(" //a[@id='welcome']"));
	        
	       // Assert.assertTrue(ele.contains("OrangeHRM"),"User unable to login - Invalid Credentials");
	        
	      //  Assert.assertEquals("welcome", ele);
	        
		//System.out.println("Page Title verified, user is able to login successfully");
	}
	
	
	@DataProvider(name="OrangeHrmData")
	public Object[][] passData(){
		
		ExcelDataConfig cfg= new ExcelDataConfig("C:\\Selenium\\SDET\\TestData\\ExcelData.xlsx");
		
		int rows=cfg.getRowCount(0);
		Object[][] data = new Object[rows][2];
		
		for(int i=0; i<rows;i++) {
			
			data[i][0]=cfg.getData(0, i, 0);
			data[i][1]=cfg.getData(0, i, 1);
		}
		
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
