package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\SriluJava\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
	
		driver.findElement(By.cssSelector("fieldset>input#name")).sendKeys("text");
		driver.findElement(By.cssSelector("#openwindow")).click();
		driver.findElement(By.cssSelector("a[id^='ope']")).click();
		
		
		driver.quit();
	}

}
