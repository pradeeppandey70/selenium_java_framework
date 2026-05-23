package options;

import org.openqa.selenium.firefox.FirefoxOptions;

import base.ConfigReader;

public class FirefoxOptionsManager implements BrowserOptions<FirefoxOptions> {

	@Override
	public FirefoxOptions getOptions() {
		FirefoxOptions options = new FirefoxOptions();

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
