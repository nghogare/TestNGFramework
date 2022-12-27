package pageEvents;

import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents {

	public void loginIntoOrangeHRM() {
		
		ElementFetch elementFetch = new ElementFetch();
		
		elementFetch.getWebElement("NAME", HomePageElements.userName).sendKeys("admin");;
		elementFetch.getWebElement("NAME", HomePageElements.password).sendKeys("admin123");
		elementFetch.getWebElement("XPATH", HomePageElements.loginButton).click();;
	}
	
}
