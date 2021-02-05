package practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class JavaScriptExecutionDemo {

	WebDriver driver;
	JavascriptExecutor js;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SriluJava\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		js=(JavascriptExecutor) driver;

	}
	@Test(enabled=false)
	public void testJavaScriptExe() {
		//driver.get("https://letskodeit.teachable.com/p/practice");
		js.executeScript("window.location='https://letskodeit.teachable.com/p/practice';");
		WebElement textBox=(WebElement) js.executeScript("return document.getElementById('name');");
		textBox.sendKeys("test");
		
		long ht=(Long) js.executeScript("return window.innerHeight;");
		long width=(Long) js.executeScript("return window.innerWidth;");

		System.out.println("Ht"+ht+"Wt"+width);
	}
	@Test(enabled=false)
	public void scrollExecution() throws InterruptedException {
		js.executeScript("window.location='https://letskodeit.teachable.com/p/practice';");
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,1900);");
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,-1900);");
		Thread.sleep(2000);
		
		WebElement ele=driver.findElement(By.id("mousehover"));

		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,-190);");

	}
	@Test
	public void testJSClick() throws InterruptedException {
		js.executeScript("window.location='https://letskodeit.teachable.com/p/practice';");
		Thread.sleep(2000);
		WebElement chkbox=driver.findElement(By.id("bmwcheck"));
		js.executeScript("arguments[0].click();",chkbox);

	}


	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
