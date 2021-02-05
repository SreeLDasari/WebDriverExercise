package practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SwitchToAlert {

	WebDriver driver;
	
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
		driver.findElement(By.id("name")).sendKeys("avy");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
	
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		Alert alert2=driver.switchTo().alert();
		alert2.dismiss();
	
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
