package com.com.autodesk.Products.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
 
@Listeners(com.crm.autodesk.GenericUtilities.Listeners.class)
public class TC_01_CreateProductTest extends BaseClass {

	@Test(groups="SmokeSuite",retryAnalyzer = com.crm.autodesk.GenericUtilities.RetryAnalyzer.class)
	public void createOrganisationTest() throws Throwable {
		
		String Productname = efu.getExcelData("Contact", 1, 2);
		String Partnumber = efu.getExcelData("Contact", 1, 5);

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(Productname+ju.getRandomNum());
		driver.findElement(By.id("productcode")).sendKeys(Partnumber);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//String productno = driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[2]")).getText();
		
		WebElement Pfinfo = driver.findElement(By.className("lvtHeaderText"));
   		wdu.waitForElementVisibility(driver, Pfinfo);
		driver.findElement(By.linkText("Products")).click();
		
		WebElement Product = driver.findElement(By.className("moduleName"));
		wdu.waitForElementVisibility(driver, Product);
		
		driver.findElement(By.className("txtBox")).sendKeys(Partnumber);
		
		WebElement searchfieled = driver.findElement(By.name("search_field"));
		wdu.select(searchfieled, "Part Number");
		
		driver.findElement(By.name("submit")).click();
  		 
		//WebElement Productdetails = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]"));

		List<WebElement> Productdetails= driver.findElements(By.cssSelector("[class='lvtColData']"));

		for(WebElement s:Productdetails) 
		{
			String expected = s.getText();
			System.out.println(expected);
			if(expected.contains(Partnumber))
			{
				System.out.println("Part Number found");
			}
			else {
				System.out.println("Part Number Not found");
			}
		}
		 Assert.assertEquals(false, true);

		 WebElement list = driver.findElement(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td[1]"));
		 wdu.mouseOver(driver, list);
		 
		 driver.findElement(By.xpath
				("//a[text()='Sign Out']")).click();
   		
		
	}
}


