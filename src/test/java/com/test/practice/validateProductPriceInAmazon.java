package com.test.practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class validateProductPriceInAmazon {
	WebDriver driver;
		
		@Test
		public void caputurProductPriceInAmazon() {
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
			driver.get("https://www.amazon.in/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String actualPrice = "mobile under 15000";
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(actualPrice);
			driver.findElement(By.id("nav-search-submit-button")).click();
			driver.findElement(By.xpath("//span[text()='See more']")).click();
			
			driver.findElement(By.xpath("//li[@aria-label='MI']//label/i")).click();
			
			String productname ="Redmi 6 Pro (Blue, 4GB RAM, 64GB Storage)";
			String exepectedprice = driver.findElement(By.xpath
					("//span[text()='"+ productname  +"']/../../../../div[3]//span[@class='a-price-whole']")).getText();
			
			System.out.println(exepectedprice );
			
			if(!actualPrice.equals(exepectedprice))
			{
				System.out.println("Given price under 15000");
			}
			else {
				System.out.println("Given price equals 15000");
			}
			
			driver.quit();
			
	}
}
