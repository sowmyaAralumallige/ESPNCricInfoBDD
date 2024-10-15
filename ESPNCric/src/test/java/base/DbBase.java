package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DbBase {
	
	 public static WebDriver driver = new ChromeDriver();	 
	 public String webPageURL = "https://www.espncricinfo.com/";	 
	 public WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		
	@BeforeSuite
	public static void setProperty() {
		System.setProperty("WebDriver.chrome.driver", ".\\src\\chromeDriver\\chromedriver.exe");		
	}
	
	@AfterSuite
	public static void driverQuit() {
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

}
