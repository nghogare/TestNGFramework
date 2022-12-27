package test;

import org.testng.annotations.Test;

import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;


public class TestRunnerClass extends BaseTest{
	
	@Test(description = "This is Login into Orange HRM Test")
	public void loginIntoOrangeHRM() {
		
		HomePageEvents homePageEvents = new HomePageEvents();
		homePageEvents.loginIntoOrangeHRM();
		
		LoginPageEvents loginPageEvents = new LoginPageEvents();
		loginPageEvents.verifyAdminDashboardOpenedOrNot();
		
			
	}
	
	@Test(description = "This is demo test 1")
	public void demoTest1() {
		
		System.out.println("I am in demo test 1");
	}
	
	@Test(description = "This is demo test 2")
	public void demoTest2() {
		
		System.out.println("I am in demo test 2");
	}

}
