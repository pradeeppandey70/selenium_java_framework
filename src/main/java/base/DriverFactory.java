package base;

import java.net.URL;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import drivers.BrowserFactory;
import drivers.ChromeBrowser;
import drivers.EdgeBrowser;
import drivers.FirefoxBrowser;
import utils.LoggerUtils;

public class DriverFactory {
	private static final Logger log = LoggerUtils.getLogger(DriverFactory.class);
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void initDriver() {
		log.info("Initializing driver");

		String browser = System.getProperty("browser");
		String executionMode = ConfigReader.get("execution.mode", "local");

		WebDriver webDriver = null;

		if (browser == null || browser.isEmpty()) {
			browser = ConfigReader.get("browser", "chrome");
		}

		System.out.println("Running on browser: " + browser);

		try {
			if (executionMode.equalsIgnoreCase("remote")) {

				URL gridUrl = new URL(ConfigReader.get("grid.url"));
				MutableCapabilities options;
				switch (browser.toLowerCase()) {

				case "firefox":
					options = new FirefoxOptions();
					break;

				case "edge":
					options = new EdgeOptions();
					break;

				case "chrome":

				default:
					options = new ChromeOptions();
					break;
				}

				webDriver = new RemoteWebDriver(gridUrl, options);

			} else {

				BrowserFactory factory;

				switch (browser.toLowerCase()) {

				case "firefox":
					factory = new FirefoxBrowser();
					break;
				case "edge":
					factory = new EdgeBrowser();
					break;
				case "chrome":
					factory = new ChromeBrowser();
					break;
				default:
					factory = new ChromeBrowser();
					break;
				}
				webDriver = factory.createDriver();

			}
			driver.set(webDriver);
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getDriver().manage().deleteAllCookies();

		} catch (Exception e) {
			throw new RuntimeException("driver initialisation failed", e);
		}

	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

}
