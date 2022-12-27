package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import test.BaseTest;


public class SuiteListener implements ITestListener, IAnnotationTransformer {

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	
	
	}

	@Override
	public void onTestSkipped(ITestResult iTestresult) {
		
		String fileName = System.getProperty("user.dir")+ File.separator + "Screenshots" + File.separator + iTestresult.getMethod().getMethodName();
		File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(f, new File(fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
	}

	@Override
	public void transform(ITestAnnotation iTestannotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		iTestannotation.setRetryAnalyzer(RetryAnalyser.class);
		
	}
	
	

}
