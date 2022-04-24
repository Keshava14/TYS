package PracticeMaven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.JSON_FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {
	JSON_FileUtility json = new JSON_FileUtility();

	@Test
	@Parameters("Browser")
	public void contactTest(String Browser) throws IOException, ParseException{
		
		//	public void contactTest(String Browser) throws IOException, ParseException{
		//	String Browser = json.readDataFromJSON("browser");

		WebDriver driver=null;

		if(Browser.equals("chrome")) 
		{
			System.out.println("Chrome Browser");
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if(Browser.equals("firefox")) 
		{
			System.out.println("firefox Browser");
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
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
			driver =new OperaDriver();
		}
		else if(Browser.equals("Iexplorer")) 
		{
			System.out.println("Ie Browser");
			WebDriverManager.iedriver().setup();
			driver =new InternetExplorerDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}

		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();

		driver.close();
	}
}

