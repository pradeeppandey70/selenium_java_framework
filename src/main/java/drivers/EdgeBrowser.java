package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import options.BrowserOptions;
import options.EdgeOptionsManager;

public class EdgeBrowser implements BrowserFactory {

	@Override
	public WebDriver createDriver() {
		WebDriverManager.edgedriver().setup();
		BrowserOptions<EdgeOptions>optionsManager = new EdgeOptionsManager();
		EdgeOptions options = optionsManager.getOptions();
		return new EdgeDriver(options);
 
	}

}
