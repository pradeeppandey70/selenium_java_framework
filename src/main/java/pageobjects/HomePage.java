package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	
	//private By textbox = By.id("APjFqb");
	
	private WebElement textboxs = driver.findElement(By.id("APjFqb"));
	
	private WebElement search = driver.findElement(By.name("btnK"));
	
	
	public void enterContent(String text) {
		type(textboxs,text);
	}
	
	public void clickSearchButton() {
		click(search);
	}
	
	public void google_search(String text) {
		enterContent(text);
		clickSearchButton();
	}
}
