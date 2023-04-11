package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

public static WebDriver driver;
	
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/hussienhammad/Desktop/SeleniumTools/chromeDriver/chromedriver_mac64 (6)/chromedriver");
		
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5);

		}
		return driver;
	}
	
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
