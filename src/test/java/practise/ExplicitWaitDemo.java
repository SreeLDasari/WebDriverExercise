package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitDemo {
	WebDriver driver;
	String baseUrl="https://letskodeit.teachable.com/";
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SriluJava\\chromedriver.exe");
		driver=new ChromeDriver();
	
		driver.manage().window().maximize();
	
	}
	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();
		WebDriverWait wait=new WebDriverWait(driver,3);
		WebElement user=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		driver.findElement(By.id("user_email")).sendKeys("abc@gmail.com");
		
  }
	
	@AfterMethod
	public void afterMethod() {
	
		driver.close();
	}
}
