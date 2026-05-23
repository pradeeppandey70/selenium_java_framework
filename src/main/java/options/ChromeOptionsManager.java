package options;

import org.openqa.selenium.chrome.ChromeOptions;

import base.ConfigReader;

public class ChromeOptionsManager implements BrowserOptions<ChromeOptions> {

	@Override
	public ChromeOptions getOptions() {
		ChromeOptions options = new ChromeOptions();

		if (isEnabled("headless")) {
			options.addArguments("--headless=new");
		}

		if (isEnabled("incognito")) {
			options.addArguments("--incognito");
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
