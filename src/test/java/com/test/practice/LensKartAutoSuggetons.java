package com.test.practice;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LensKartAutoSuggetons {

	@Test
		public void takeScreenshot() {
			
//			System.setProperty("webdriver.chrome.driver", 
//					"C:\\Users\\USER\\Documents\\OMCA6_AUTOMATION\\chromedriver\\chromedriver.exe" );
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.amazon.com/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//			driver.findElement(By.name("q")).click();			
//			List<WebElement> list = driver.findElements(By.xpath("//div[@class='trending']"));
//			
//			// for all links in UI
//			//List<WebElement> list = driver.findElements(By.tagName("ul"));
//			
//			for(WebElement wb : list)
//			{
//				System.out.println("Total Suggetions are: "+ "\n" +wb.getText());
//			}
			
			WebElement ele=driver.findElement(By.id("searchDropdownBox"));
			ele.click();
			Select s= new Select(ele);
//			for(WebElement wb:s.getOptions()) {
//				System.out.println(wb.getText());
//			}
			s.selectByIndex(4);
			//driver.close();
	}
		
}
