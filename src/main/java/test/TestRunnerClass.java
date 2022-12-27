package test;

import org.testng.annotations.Test;

import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;


public class TestRunnerClass extends BaseTest{
	
	@Test
	public void loginIntoOrangeHRM() {
		
		HomePageEvents homePageEvents = new HomePageEvents();
		homePageEvents.loginIntoOrangeHRM();
		
		LoginPageEvents loginPageEvents = new LoginPageEvents();
		loginPageEvents.verifyAdminDashboardOpenedOrNot();
		
			
	}
	
	@Test
	public void demoTest1() {
		
		System.out.println("I am in demo test 1");
	}
	
	@Test
	public void demoTest2() {
		
		System.out.println("I am in demo test 2");
	}

}
