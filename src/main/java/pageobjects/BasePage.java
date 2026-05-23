package pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.DriverFactory;
import utils.ActionUtils;
import utils.JavaScriptUtils;
import utils.LoggerUtils;
import utils.WaitUtils;

public class BasePage {
	protected WebDriver driver;
	protected WaitUtils wait;
	protected ActionUtils action;
	protected JavaScriptUtils js;
	private static final Logger log = LoggerUtils.getLogger(BasePage.class);
	
	public BasePage() {
		this.driver = DriverFactory.getDriver();
		wait = new WaitUtils(driver);
        action = new ActionUtils(driver);
        js = new JavaScriptUtils(driver);
		
	}
	
	protected void click(WebElement element) {
		log.info("Clicking element: "+ element);
		element.click();
	}
	
	protected void type(WebElement element, String text) {
		log.info("clearing element: "+ element);
        element.clear();
        log.info("writing text: "+ element);
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
    	log.info("getting text from : "+ element);
        return element.getText();
    }

    protected boolean isDisplayed(WebElement element) {
    	log.info("checking element display : "+ element);
        return element.isDisplayed();
    }
    
    public void hover(WebElement element) {
    	log.info("hovering : "+ element);
    	action.hover(element);
    }

}
