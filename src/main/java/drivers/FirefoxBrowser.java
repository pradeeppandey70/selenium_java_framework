package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import options.BrowserOptions;
import options.FirefoxOptionsManager;

public class FirefoxBrowser implements BrowserFactory {

	@Override
	public WebDriver createDriver() {
		WebDriverManager.firefoxdriver().setup();
		
		BrowserOptions<FirefoxOptions> optionsManager = new FirefoxOptionsManager();
		FirefoxOptions options = optionsManager.getOptions();
		return new FirefoxDriver(options);
	}

}
