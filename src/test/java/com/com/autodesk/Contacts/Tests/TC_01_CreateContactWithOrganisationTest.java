package com.com.autodesk.Contacts.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.ExcelFileUtility;
import com.crm.autodesk.GenericUtilities.JSON_FileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;
import com.crm.autodesk.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_CreateContactWithOrganisationTest {
	WebDriver driver;
	@Test
	public void createContactWithOrganization() throws Throwable{

		//read all the necessary data
		JSON_FileUtility jfu =new JSON_FileUtility();
		JavaUtility ju =new JavaUtility();
		WebDriverUtility wdu =new WebDriverUtility();
		ExcelFileUtility efu = new ExcelFileUtility();

		String Url = jfu.readDataFromJSON("url");
		String Browser = jfu.readDataFromJSON("browser");
		String Username = jfu.readDataFromJSON("username");
		String Password = jfu.readDataFromJSON("password");

		String contactName = efu.getExcelData("Contact", 1, 3);
		String OrgName = efu.getExcelData("Contact", 1, 4);

		//Launch the browser
		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();				
		}
		else if(Browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}

		wdu.waitForPageLoad(driver);
		wdu.maximizeWindow(driver);
		driver.get(Url);

		//login to application 
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();

		//click on contact
		driver.findElement(By.linkText("Contacts")).click();

		//click on create contact
		driver.findElement(By.xpath("//img[@title ='Create Contact...']")).click();

		//create contact
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();

		//switch to child window
		wdu.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("demovtiger")).click();

		// switch back to parent window
		wdu.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//logout
		WebElement ele = driver.findElement(By.xpath
				("//img[@src='themes/softed/images/user.PNG']"));
		wdu.mouseOver(driver,ele);
		driver.findElement(By.linkText("Sign Out")).click();

		driver.close();

	}
}
