package com.test.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTripCurrentDate {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\USER\\OneDrive\\Documents\\OMCA6_AUTOMATION\\chromedriver.exe" );
//		
//		ChromeDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		driver.get("https://www.makemytrip.com/");
//		
//		
//		driver.findElement(By.cssSelector("[placeholder='From']")).click();
		
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.amazon.in/");
			driver.findElement(By.xpath("//a[.=\"Fashion\"]")).click();
			driver.findElement(By.xpath("//a[.=\"Fashion & beauty\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
			List<WebElement> text = driver.findElements(By.xpath("//span[contains(text(), \"T-Shirt\")]"));
			int count=0;
			for(WebElement word:text)
			{
				count++;
				System.out.println(word.getText());
			}
			
			System.out.println("TotalCount"+count);
			
			driver.close();
			
		}
	

	}

