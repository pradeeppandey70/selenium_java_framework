package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.DriverFactory;

public class ScreenshotUtils {
	public static String capture(String testname) {
		File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		String path = "reports/screenshot/" + testname;
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

}
