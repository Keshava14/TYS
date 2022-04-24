package com.crm.autodesk.GenericUtilities;

import org.json.simple.parser.ParseException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass2 {
	public static WebDriver staticdriver;

	public WebDriver driver;
	public DataBaseUtility du = new DataBaseUtility();
	public JSON_FileUtility jfu =new JSON_FileUtility();
	public JavaUtility ju = new JavaUtility();
	public ExcelFileUtility efu = new ExcelFileUtility();
	public WebDriverUtility wdu = new WebDriverUtility();
	public PropertyFile pf = new PropertyFile();

	@BeforeSuite
	public void dConnectDB1() throws Throwable {
		//du.connectToDB();
		System.out.println(">>>>Make 4 Connection>>>>");
	}
	@BeforeTest
	public void ConnectDB1() throws Throwable {
		//du.connectToDB();
		System.out.println(">>>>Make 1 Connection>>>>");
	}
	@BeforeClass
	public void lanuchBrowser(String Browser) throws Throwable, ParseException {
		//	public void lanuchBrowser() throws Throwable {

		String Url = jfu.readDataFromJSON("url");
		//		String Browser = jfu.readDataFromJSON("browser");

		if(Browser.equals("chrome"))
		{
			System.out.println("Chrome Browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equals("firefox")) 
		{
			System.out.println("firefox Browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(Browser.equals("edge")) 
		{
			System.out.println("edge Browser");
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		}
		else if(Browser.equals("opera")) 
		{
			System.out.println("Opera Browser");
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		else  {
			System.out.println("Invalid Browser");
		}
		wdu.waitForPageLoad(driver);
		wdu.maximizeWindow(driver);
		driver.get(Url);
		staticdriver = driver;
	}

	@BeforeMethod
	public void ConnectDB3() throws Throwable {
		//du.connectToDB();
		System.out.println(">>>>Make 3 Connection>>>>");	
	}
	@Test
	public void boy() {
		System.out.println("hiii");
	}
	@AfterTest
	public void aConnectDB1() throws Throwable {
		//du.connectToDB();
		System.out.println(">>>>Make a Connection>>>>");
	}
	@AfterClass
	public void closeBrowser() 
	{
		System.out.println("Close Browser");
		driver.close();;
	}
	@AfterMethod
	public void cConnectDB3() throws Throwable {
		//du.connectToDB();
		System.out.println(">>>>Make c Connection>>>>");
		
	}
	@AfterSuite
	public void eConnectDB1() throws Throwable {
		//du.connectToDB();
		System.out.println(">>>>Make e Connection>>>>");
	}
}
