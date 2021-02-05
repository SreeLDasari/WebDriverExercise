package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

public class WDEListeners {

	public static void main(String[] args) {

		String baseUrl="https://letskodeit.teachable.com/";
		System.setProperty("webdriver.chrome.driver", "D:\\SriluJava\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		HandleEvents he=new HandleEvents();
		eDriver.register(he);
	
		eDriver.get(baseUrl);
		WebElement signuplink=eDriver.findElement(By.linkText("Login"));
		signuplink.click();
		
				
		
	}

}
