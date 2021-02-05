package practise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class BasicActions {

	WebDriver driver;
	String baseUrl="https://letskodeit.teachable.com/";
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.firefox.driver", "D:\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	@Test(enabled=false)
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("user_email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("abc");
		driver.findElement(By.name("commit")).click();
		driver.navigate().back();
		driver.navigate().forward();

	}
	@Test(enabled=false)
	public void testWebElements() {
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.findElement(By.id("bmwradio")).click();
		driver.findElement(By.id("carselect")).click();
		driver.findElement(By.id("benzcheck")).click();
		List<WebElement> radio=driver.findElements(By.name("cars"));
		System.out.println(radio.size());
		for(int i=0;i<3;i++) {
			radio.get(i).click();
		}
		WebElement dd=driver.findElement(By.id("carselect"));
		Select sel=new Select(dd);
		sel.selectByIndex(0);
	}

	@Test
	public void autoComplete() throws InterruptedException {
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("D");
		WebElement ulElement=driver.findElement(By.id("react-autosuggest-1"));
		List<WebElement> destlist=ulElement.findElements(By.tagName("li"));
		Thread.sleep(3000);
		for(WebElement ele:destlist) {
			System.out.println(ele.getText());
			if(ele.getText().contains("Delhi, India(DEL)")) {
				ele.click();
				break;
			}
		}
		
	}
	
	

	@AfterMethod
	public void afterMethod() throws IOException {
		TakesScreenshot scrShot=(TakesScreenshot) driver;
		File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\ramba\\eclipse-workspace\\WebDriverExercise\\test.png");
		org.apache.commons.io.FileUtils.copyFile(srcFile, dest);
		
	
		driver.quit();
	}

}
