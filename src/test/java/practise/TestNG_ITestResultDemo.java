package practise;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_ITestResultDemo {

	WebDriver driver;
	String baseUrl="https://letskodeit.teachable.com/";
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.firefox.driver", "D:\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("user_email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("abc");
		driver.findElement(By.name("ommit")).click();
		driver.navigate().back();
		driver.navigate().forward();

	}
  @AfterMethod
  public void aftermthd(ITestResult itestresult) throws IOException {
	  if(itestresult.getStatus()==ITestResult.FAILURE) {
		  System.out.println("Failed tests : "+ itestresult.getName());
		  TakesScreenshot scrShot=(TakesScreenshot) driver;
			File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\ramba\\eclipse-workspace\\WebDriverExercise\\test.png");
			org.apache.commons.io.FileUtils.copyFile(srcFile, dest);
			
	  }
	  if(itestresult.getStatus()==ITestResult.SUCCESS) {
		  System.out.println("Passed tests : "+ itestresult.getName());
	  }
  }
  
}
