package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		//String browser = "chrome";
		//String url = "https://google.com";
		DriverFactory.initDriver();
		driver = DriverFactory.getDriver();
		
		driver.get(ConfigReader.get("url"));
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
