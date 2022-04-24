package PracticeMaven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.autodesk.GenericUtilities.BaseClass;


public class Newclass implements ITestListener  {

	ExtentReports reports;
	ExtentTest test;
	public String getScreenshot(String name) throws IOException {

		TakesScreenshot staticdriver = null;
		File srcfile =((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile =System.getProperty("User.dir")+"/screenshot"+name+".png";

		File finaldest = new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);

		return destfile;	
	}

	@Override
	public void onFinish(ITestContext result) {
		reports.flush();
	}
	@Override
	public void onStart(ITestContext result) {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter
				(System.getProperty("user.dir")+"/ExtentReportsSDET21/ExtentReport3.html");
		reporter.config().setDocumentTitle("SDET21");

		reports = new ExtentReports();
		reports.attachReporter(reporter);


	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestFailure(ITestResult result) {
		try{
			BaseClass bc =new BaseClass();
			bc.getScreenShot(result.getMethod().getMethodName());
		}
		catch(IOException e){
			e.printStackTrace();
		}	
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	} 

}
