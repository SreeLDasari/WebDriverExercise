package practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class MouseHoverDemo {

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
	@Test
	public void testJavaScriptExe() throws InterruptedException {
		driver.get("https://letskodeit.teachable.com/p/practice");
		js.executeScript("window.scrollBy(0,600);");
		WebElement mainele=driver.findElement(By.id("mousehover"));
		Actions action=new Actions(driver);
		action.moveToElement(mainele).perform();
		
		WebElement ele=driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
		action.moveToElement(ele).click().perform();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
