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

public class OrangeHRMLogin {

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
		
		Object[][] data = new Object[3][2];
		
		data[0][0]="Admin123";
		data[0][1]="admin123";
		
		data[1][0]="Admin";
		data[1][1]="admin123";
		
		data[2][0]="Admin456";
		data[2][1]="admin123";
		
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
