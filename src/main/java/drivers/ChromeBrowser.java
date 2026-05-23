package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import options.BrowserOptions;
import options.ChromeOptionsManager;

public class ChromeBrowser implements BrowserFactory {

	@Override
	public WebDriver createDriver() {
		WebDriverManager.chromedriver().setup();

		BrowserOptions<ChromeOptions> optionsManager = new ChromeOptionsManager();
		ChromeOptions options = optionsManager.getOptions();

		return new ChromeDriver(options);

	}

}
