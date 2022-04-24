package com.test.practice;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.crm.autodesk.GenericUtilities.JSON_FileUtility;

public class DynamicWebTable {
	
	public static void main(String[] args) throws Throwable {
	
//	System.setProperty("webdriver.opera.driver",
//				"C:\\Users\\USER\\Documents\\OMCA6_AUTOMATION\\Browser driver\\operadriver.exe" );
	WebDriver driver;

	
	JSON_FileUtility jsf = new JSON_FileUtility();
	
	String Url =jsf.readDataFromJSON("url");
	String Browser = jsf.readDataFromJSON("browser");
	String Username = jsf.readDataFromJSON("username");
	String Password = jsf.readDataFromJSON("password");
	
	
	if(Browser.equalsIgnoreCase("opera")) {
		driver= new OperaDriver();
	}
	else if(Browser.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
	}
	else{
		driver= new InternetExplorerDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(Url);
	driver.findElement(By.name("user_name")).sendKeys(Username);
	driver.findElement(By.name("user_password")).sendKeys(Password);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Organizations")).click();
	 
//	//List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']"));
//	List<WebElement> list= driver.findElements(By.xpath
//			("//table/[@class='vt small']/tbody/tr[*]/td[1]/input[@name='selectall']"));
//			 for(int i=1;i<list.size();i++) 
//			 {
//				 for(WebElement wb : list) {
//				 System.out.println(wb.getText());
//				 }
//			 }
	
	driver.findElement(By.id("selectCurrentPageRec")).click();
	System.out.println("pass");
	driver.close();
	}
}

