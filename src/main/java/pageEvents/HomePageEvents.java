package pageEvents;

import pageObjects.HomePageElements;
import test.BaseTest;
import utils.ElementFetch;

public class HomePageEvents {

	public void loginIntoOrangeHRM() {
		
		ElementFetch elementFetch = new ElementFetch();
		
		BaseTest.logger.info("Entering Username");
		elementFetch.getWebElement("NAME", HomePageElements.userName).sendKeys("admin");
		BaseTest.logger.info("Entering Password");
		elementFetch.getWebElement("NAME", HomePageElements.password).sendKeys("admin123");
		BaseTest.logger.info("Clicking on Login Button");
		elementFetch.getWebElement("XPATH", HomePageElements.loginButton).click();;
	}
	
}
