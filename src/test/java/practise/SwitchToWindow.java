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

public class SwitchToWindow {

	WebDriver driver;
	JavascriptExecutor js;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\SriluJava\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	@Test(enabled=false)
	public void testJavaScriptExe() throws InterruptedException {
		driver.get("https://letskodeit.teachable.com/p/practice");
		String parent=driver.getWindowHandle();
		System.out.println(parent+" parent window");
		driver.findElement(By.id("openwindow")).click();

		Set<String> handles=driver.getWindowHandles();
		for(String handle:handles) {
			System.out.println(handle);
			if(!handle.equals(parent)) {
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				driver.findElement(By.id("search-courses")).sendKeys("Python");
				driver.findElement(By.id("search-course-button")).click();
				driver.close();
				break;
			}
		}
		driver.switchTo().window(parent);

	}
	@Test
	public void switchTab() throws InterruptedException {
		driver.get("https://letskodeit.teachable.com/p/practice");
		String parent=driver.getWindowHandle();

		driver.findElement(By.id("opentab")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		Thread.sleep(4000);
	}

		
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
