package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestNG_Parallel_Params {
	WebDriver driver;
	
	String baseUrl="https://letskodeit.teachable.com/";
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser) {
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\SriluJava\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		}else if (browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "D:\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		}
		
	
	}
	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("user_email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("abc");
		driver.findElement(By.name("commit")).click();
		driver.navigate().back();
		driver.navigate().forward();
  }
	@AfterMethod
	public void afterMethod() {
	
		driver.quit();
	}
}
