package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties = new Properties();

	static {
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/config.properties");
			properties.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	public static String get(String key) {
		String envValue = System.getenv(key.toUpperCase());
		if (envValue != null && !envValue.isEmpty()) {
			return envValue;
		}
		return properties.getProperty(key);
	}

	public static String get(String key, String def) {
		String envValue = System.getenv(key.toUpperCase());
		if (envValue != null && !envValue.isEmpty()) {
			return envValue;
		}
		return properties.getProperty(key, def);
	}

}
