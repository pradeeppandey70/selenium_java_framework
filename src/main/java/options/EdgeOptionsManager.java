package options;

import org.openqa.selenium.edge.EdgeOptions;

import base.ConfigReader;

public class EdgeOptionsManager implements BrowserOptions<EdgeOptions> {

	@Override
	public EdgeOptions getOptions() {
		EdgeOptions options = new EdgeOptions();

		if (isEnabled("headless")) {
			options.addArguments("--headless=new");
		}

		if (isEnabled("incognito")) {
			options.addArguments("--private");
		}

		if (isEnabled("maximize")) {
			options.addArguments("--start-maximized");
		}

		if (isEnabled("disableNotifications")) {
			options.addArguments("--disable-notifications");
		}

		if (isEnabled("remoteAllowOrigins")) {
			options.addArguments("--remote-allow-origins=*");
		}

		return options;
	}

	private boolean isEnabled(String key) {
		String value = System.getProperty(key);
		if (value == null) {
			value = ConfigReader.get(key, "false");
		}
		return value.equalsIgnoreCase("true");

	}

}
