package test;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Constants;

public class BaseTest {
	
	public static WebDriver driver;
	public ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;	
	
	@BeforeTest
	public void beforeTestMethod() {
		
		String path =System.getProperty("user.dir")+"\\reports\\AutomationReport.html"; 
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); 
		reporter.config().setReportName("Web Automation Results"); 
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);
		extent =new ExtentReports(); 
		extent.attachReporter(reporter); 
		extent.setSystemInfo("QA Tester", "Nitin Ghogare"); 
		
	}
	
	
	//getting browser name from testNG file using data provider
	
	@BeforeMethod
	@Parameters(value={"browsername"})
	public void beforeMethodMethod(String browsername, Method testMethod) {
		logger = extent.createTest(testMethod.getName());
		setupDriver(browsername);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //deprecated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(Constants.url);
	}
	
	@AfterMethod
	public void AfterMethodMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case: " + methodName+ " Passed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			logger.log(Status.PASS, m);			
			
		}
	
		else if(result.getStatus()==ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case: " + methodName+ " Failed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			logger.log(Status.FAIL, m);
			
		}
		
		driver.quit();		
		
	}
	
	@AfterTest
	public void AfterTestMethod() {
			
		extent.flush();
		
	}
	
	public void setupDriver(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\firefoxdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			//default case if no browser is provided
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
	}

}
