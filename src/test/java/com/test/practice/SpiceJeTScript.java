package com.test.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SpiceJeTScript {

	public static void main(String[] args) throws InterruptedException {

	System.setProperty("webdriver.chrome.driver" ,
			"C:\\Users\\USER\\Downloads\\chromedriver_95\\chromedriver.exe");
	
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
		
	WebDriver driver = new ChromeDriver(option);

	driver.get("https://beta.spicejet.com/");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("https://beta.spicejet.com/");
	
	//Locate the from element and enter the origin:Bengaluru
	driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).sendKeys("Bengaluru");
	
	//Locate the from element and enter the destination:Delhi
	WebElement ele = driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[2]"));
	ele.clear();
	ele.sendKeys("Delhi");
	
	//Locate the element and give the date
		
	driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")).click();
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
	Thread.sleep(5000);
	
	WebElement ele1 = driver.findElement(By.xpath("//span[@class='css-76zvg2 css-16my406 r-homxoj r-1n0xq6e r-1s6pnzw r-1iadsmv']"));
	String OneWay = ele1.getText();
	
	//validation
	Assert.assertEquals(OneWay," One Way : Bengaluru to Delhi");
	System.out.println("One Way Verified");
	Thread.sleep(5000);
	
	WebElement ele2 = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar r-1n0xq6e']"));
	String date = ele2.getText();
	
	Assert.assertEquals(date,"Fri, 05 Nov 2021");
	System.out.println("Date is matched and Verified");
	
	driver.close();
	}
}
