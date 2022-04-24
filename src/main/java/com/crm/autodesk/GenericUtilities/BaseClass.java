package com.crm.autodesk.GenericUtilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.com.autodesk.Elementrepository.HomePage;
import com.com.autodesk.Elementrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains generic methods for Entire Execution
 * @author Keshava
 *
 */
public class BaseClass {

	//public static WebDriver monitorDriver;
	public static WebDriver staticdriver;

	public WebDriver driver;
	public DataBaseUtility du = new DataBaseUtility();
	public JSON_FileUtility jfu =new JSON_FileUtility();
	public JavaUtility ju = new JavaUtility();
	public ExcelFileUtility efu = new ExcelFileUtility();
	public WebDriverUtility wdu = new WebDriverUtility();
	public PropertyFile pf = new PropertyFile();

	@BeforeSuite(alwaysRun = true)
	public void ConnectDB() throws Throwable {
		//du.connectToDB();
		System.out.println(">>>>Make DB Connection>>>>");
	}

	//	@Parameter("Browser")
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	//	public void lanuchBrowser(String Browser) throws Throwable, ParseException {
	public void lanuchBrowser() throws Throwable {

		String Browser = jfu.readDataFromJSON("browser");
		String Url = jfu.readDataFromJSON("url");

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

	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void loginToApp() throws IOException, ParseException {

		String Username = jfu.readDataFromJSON("username");
		String Password = jfu.readDataFromJSON("password");

		System.out.println("Login into App");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(Username, Password);
	}

	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void logout() {

		System.out.println("LogOut from App");
		HomePage hp = new HomePage(driver);
		hp.getSignoutLnk();
	}

	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void closeBrowser() 
	{
		System.out.println("Close Browser");
		driver.close();;
	}
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void DisConnectDB() throws Throwable {
		//du.closeDb();
		System.out.println(">>>> DisCnnect DB Connection>>>>");
	}

	public String getScreenShot(String name) throws IOException {

		//		EventFiringWebDriver efwd = new EventFiringWebDriver(BaseClass.monitorDriver);
		//		File srcFile =efwd.getScreenshotAs(OutputType.FILE);

		File srcFile =((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir")+"/screenshots/"+ name +".png";

		File finaldest =new File(destfile);
		FileUtils.copyFile(srcFile, finaldest);

		return destfile;
	}
}
