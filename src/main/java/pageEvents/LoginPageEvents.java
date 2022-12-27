package pageEvents;

import org.testng.Assert;

import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
	
	public void verifyAdminDashboardOpenedOrNot() {
		
		ElementFetch elementFetch = new ElementFetch();
			
		Assert.assertEquals(elementFetch.getWebElement("XPATH", LoginPageElements.verifyAdminText).getText(), "Admin","Login page not opened");
	
	
	}

}
