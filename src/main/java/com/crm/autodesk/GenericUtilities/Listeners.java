package com.crm.autodesk.GenericUtilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
/**
 * This class contains generic methods to Monitor Execution and Take ScreenShot
 * @author Keshava
 *
 */
public class Listeners implements ITestListener {
	
	ExtentReports reports;
	ExtentTest test;
	
	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter
				(System.getProperty("user.dir")+"/ExtentReportsSDET21/ExtentReport3.html");
		reporter.config().setDocumentTitle("SDET21");
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("BiuldNo", "5.1");
		reports.setSystemInfo("Enviroment", "Pre-Production");
		reports.setSystemInfo("Platform", "Windows");
		reports.setSystemInfo("Browser Version", "Chrome-93");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, result.getThrowable());
		
		test.log(Status.FAIL, result.getName()+ "is Failed");
		
		BaseClass baseclass = new BaseClass();
		
		try {
			String path = baseclass.getScreenShot(result.getName());
			test.addScreenCaptureFromPath(path);
			
// Normal:: baseclass.getScreenShot(result.getMethod().getMethodName());

		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
	} 

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+ "is Skipped");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+ "is Passed");
		
	}

}
