package PracticeMaven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AAAmazonLogin {
	WebDriver driver;
	
	@Test
	public void amazonLogin() throws AWTException, InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
//	driver.findElement(By.xpath("//span[text()='Made for Amazon']")).click();
////	JavascriptExecutor jse = (JavascriptExecutor) driver;
////	jse.executeAsyncScript("window.scrollBy(0,800);");
////	
////	String value=(String) jse.executeScript("document.getElement By xpath('//span[text()='Dyazo 4.8 Amp (2.4 & 2.4 Amp) Dual Port Fast Car Charger Compatible with iPhone XR/Xs/Max/X/8/7/Plus, Ipad Pro/Air 2/Mini, Galaxy, LG, HTC and All Other Mobile Phones with Free 3 in 1 Cable']/ancestor::div[@class='a-section a-spacing-none']/descendant::span[@class='a-price']').getText()");
////	String price = value.getText();
//	Robot r = new Robot();
//	r.keyPress(KeyEvent.VK_PAGE_DOWN);
//	
//	String price = driver.findElement(By.xpath
//("//span[text()='Dyazo 4.8 Amp (2.4 & 2.4 Amp) Dual Port Fast Car Charger Compatible with iPhone XR/Xs/Max/X/8/7/Plus, Ipad Pro/Air 2/Mini, Galaxy, LG, HTC and All Other Mobile Phones with Free 3 in 1 Cable']/ancestor::div[@class='a-section a-spacing-none']/descendant::span[@class='a-price']")).getText();
//	r.keyRelease(KeyEvent.VK_PAGE_DOWN);
//
//	System.out.println(price);
	
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("xioami");
	driver.findElement(By.id("nav-search-submit-button")).click();
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_PAGE_DOWN);
	WebElement mbn = driver.findElement(By.xpath("//span[text()='Redmi 9 (Sporty Orange, 4GB RAM, 64GB Storage) | 2.3GHz Mediatek Helio G35 Octa core Processor']"));
	System.out.println("Mobile Name : "+mbn.getText());
	mbn.click();
	r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	Thread.sleep(1000);
	String mainID = driver.getWindowHandle();
	Set<String> allID = driver.getWindowHandles();
	for(String id : allID)
	{
		if(!mainID.equals(id))
		{
			driver.switchTo().window(id);
			Thread.sleep(1000);
			String mbPrime =driver.findElement(By.xpath("//span[text()='        Redmi 9 (Sporty Orange, 4GB RAM, 64GB Storage) | 2.3GHz Mediatek Helio G35 Octa core Processor       ']/following::span[@class='a-price a-text-price a-size-medium apexPriceToPay']")).getText();
			System.out.println("Mobile Price : "+mbPrime);
		}
		driver.close();

	}
	
		
	System.out.println("pass");	
	
	}
}
