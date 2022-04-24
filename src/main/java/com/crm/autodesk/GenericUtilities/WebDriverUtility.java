package com.crm.autodesk.GenericUtilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/**
 * This class contains all the generic methods related to webdriver actions
 * @author Keshava
 *
 */
public class WebDriverUtility {
	/**
	 * this method will wait for the page to load for 10 seconds
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * this method will Explicitly wait for perticular condition to be satisfied for 10 seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	 
	/**
    * This method wait for the element to be clicked , its custom wait created to avoid elemenInterAceptable Exception
    * @param element
    * @throws throwable
    * 
    */   
	 public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }       
	   }

	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method will select from the dropdown using value
	 * @param element
	 * @param value
	 */
	public void select1(WebElement element,String value) 
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method will select from the dropdown using visible text
	 * @param element
	 * @param visible text
	 */
	public void select(WebElement element,String visibleText) 
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	/**
	 * this method will select from the dropdown using Index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method will do mouse over action on WebElement
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element)
	{
		Actions act =  new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method will perform rirht click on WebElement
	 * @param driver
	 * @param element
	 */
	public void   rightClick(WebDriver driver,WebElement element) 
	{
		Actions act =  new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
     * pass enter Key appertain in to Browser
     * @param driver
     */
   public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
   	}

	/**
	 * this method will perform double click on WebElement
	 * @param driver
	 * @param element
	 */
	public void   doubleClick(WebDriver driver,WebElement element) 
	{
		Actions act =  new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method will select accept on alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method will dismiss option in alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method will switch to frame WRT value
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method will switch to frame WRT ID
	 * @param driver
	 * @param frameid
	 */
	public void switchToFrame(WebDriver driver, String frameid) 
	{
		driver.switchTo().frame(frameid);
		
	}
	/**
	 * this method switch to frame WRT Element
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * this method will switch to window wiyh respect to partialWinTitle 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		
		Set<String> winhandle = driver.getWindowHandles();
		Iterator<String> it = winhandle.iterator();
		
		while(it.hasNext()) {
			String winid = it.next();
			String actualTitle = driver.switchTo().window(winid).getTitle();
			if(actualTitle.contains(partialWinTitle)) 
			{
				//driver.switchTo().window(actualTitle);
				break;
			}
					
		}
	}
	 /**
	    * This method used for scrolling action in a webpage
	    * @param driver
	    * @param element
	    */
	   public void scrollToWebElement(WebDriver driver, WebElement element) {
		   
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   int y= element.getLocation().getY();
		   js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	   
	/**
	 * this method will perform Hard Assertion strictly
	 * @param actual
	 * @param expected
	 */
	public void checkStrictHardAssertion(String actual,String expected) {
		
		Assert.assertEquals(actual, expected);
	}
	/**
	 *  this method will perform Hard Assertion Partially
	 * @param actual
	 * @param expected
	 */
	public void checkContainsHardAssertion(String actual,String expected) {
		Assert.assertTrue(actual.contains(expected));
	}
	/**
	 * this method will perform soft Assertion strictly
	 * @param actual
	 * @param expected
	 */
	public void checkStrictSoftAssertion(String actual,String expected) {
		 
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(actual,expected);
		sf.assertAll();
	}
	/**
	 * this method will perform soft Assertion Partially
	 * @param actual
	 * @param expected
	 */
	public void checkPartialSoftAssertion(String actual,String expected) {
		 
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(actual.contains(expected));
		sf.assertAll();
	}	
	
}
