package practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SwitchToFrame {

	WebDriver driver;
	JavascriptExecutor js;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SriluJava\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	@Test
	public void testJavaScriptExe() throws InterruptedException {
		driver.get("https://letskodeit.teachable.com/p/practice");
		
	//	driver.switchTo().frame("courses-iframe");
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("search-courses")).sendKeys("Java");
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
