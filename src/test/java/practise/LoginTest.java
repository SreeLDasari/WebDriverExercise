package practise;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LoginTest {

	WebDriver driver;
	String baseUrl="https://letskodeit.teachable.com/";
	ExtentReports report;
	
	ExtentHtmlReporter htmlreport;
	ExtentReporter extentx;
	public ExtentTest test;

	@BeforeTest
	public void reports() {
		htmlreport=new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport1.html");
		htmlreport.config().setDocumentTitle("Title of the Report Comes here "); 
		htmlreport.config().setReportName("Name of the Report Comes here "); 
		htmlreport.config().setTheme(Theme.STANDARD);			

		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		//test.startTest("Verify the title");
		report.setSystemInfo("Host Name", "Practise");
		report.setSystemInfo("Environment", "Production");
		report.setSystemInfo("User Name", "Sree");
		
	}
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SriluJava\\chromedriver.exe");
		driver=new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseUrl);
	
	}
	@Test
	public void test() {
		test = report.createTest("To verify Google Title");
		
		WebElement signuplink=driver.findElement(By.linkText("Login"));
		signuplink.click();
		
		WebElement username=driver.findElement(By.id("user_email"));
		username.sendKeys("test@email.com");
		
		WebElement password=driver.findElement(By.id("user_password"));
		password.sendKeys("abcabc");
		
		WebElement login=driver.findElement(By.name("commit"));
		login.click();
		Assert.assertTrue(true);
		
		driver.navigate().back();
		driver.navigate().forward();
		Assert.assertTrue(true);

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); 
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		  }
		  else if (result.getStatus() == ITestResult.SUCCESS) {
		   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		  }
		driver.quit();
		
	}
	 @AfterTest
	 public void endReport() {
	  report.flush();
		driver.quit();

	 }
}
