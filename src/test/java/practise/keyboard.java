package practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class keyboard {

	WebDriver driver;
	String baseUrl="https://letskodeit.teachable.com/";
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SriluJava\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	@Test(enabled=false)
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("user_email")).sendKeys("abc@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("user_password")).sendKeys("abc");
		Thread.sleep(3000);

		driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
		driver.navigate().back();
		driver.navigate().forward();

	}
	@Test(enabled=false)
	public void testkeyPress() throws InterruptedException {
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL+"a");
		Thread.sleep(2000);
	}
	@Test
	public void testkeyPressActions() throws InterruptedException {
		driver.get("https://letskodeit.teachable.com/p/practice");
		Thread.sleep(2000);

		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);
	}


	@AfterMethod
	public void afterMethod() throws IOException {
			driver.quit();
	}

}
