package com.com.autodesk.Contacts.Tests;

import java.io.FileInputStream;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.GenericUtilities.IPathConstants;

public class GenericMethods {

	public void windowhandle(WebDriver driver) {
		
		String mainid = driver.getWindowHandle();
		Set<String> allID = driver.getWindowHandles();
		for(String id:allID) {
			if(!mainid.equals(id)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(mainid);
		}
	}
	public void mouseOver(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public String getExcelData(String sheetname, int rownum, int cellnum ) throws  Throwable
	{
		FileInputStream fis = new FileInputStream
				("C:\\Users\\USER\\OneDrive\\Documents\\DataStorageFile\\Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		return value;
	}	

	
	public static void main(String[] args) throws Throwable {
		
		{
			GenericMethods gm= new GenericMethods();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver_95\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();

			driver.get("https://www.naukri.com/");
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			gm.windowhandle(driver);
			
			Thread.sleep(1000);
			
//			WebElement  companies = driver.findElement(By.xpath("//div[text()='Companies']"));
//			gm.mouseOver(driver, companies);
//			
//			driver.findElement(By.linkText("About Companies")).click();
			driver.findElement(By.xpath("//span[text()='Later']")).click();
			System.out.println("pass");
			String value = gm.getExcelData("Sheet1", 1, 0);
			
			WebElement data= driver.findElement(By.id("qsb-keyword-sugg"));
			data.sendKeys(value);
			String value1 = gm.getExcelData("Sheet1", 2, 0);

			WebElement data1= driver.findElement(By.cssSelector("name='location'"));
			data1.sendKeys(value1);
			
			driver.findElement(By.linkText("Search")).click();
			driver.quit();
			
		}
	}

}


