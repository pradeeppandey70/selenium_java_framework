package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowser implements BrowserFactory {

	@Override
	public WebDriver createDriver() {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
 
	}

}
