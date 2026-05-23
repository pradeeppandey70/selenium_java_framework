package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private WebDriver driver;
	private static final int TIMEOUT = 10;
	 

	public WaitUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForVisibility(WebElement element) {
		return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForClickability(WebElement element) {
		return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

}
