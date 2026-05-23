package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

	private WebDriver driver;
	private JavascriptExecutor js;
	
	public JavaScriptUtils(WebDriver driver) {

		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}

	public void clickUsingJS(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollIntoView(WebElement element) {
		
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToBottom() {
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void scrollToTop() {
	
		js.executeScript("window.scrollTo(0, 0);");
	}

	public void enterTextUsingJS(WebElement element, String text) {
		
		js.executeScript("arguments[0].value=arguments[1];", element, text);
	}

	public String getPageTitleUsingJS() {
		
		return js.executeScript("return document.title;").toString();
	}

	public void highlightElement(WebElement element) {
		
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

}
