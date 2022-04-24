package PracticeMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleProject_Maven {

	@Test
	public void sampleTest() {
		System.out.print("Execute Test");
		
		String URL = System.getProperty("url");
		String UserName = System.getProperty("username");
		String PassWord = System.getProperty("password");
		
		System.out.println(URL);
		System.out.println(UserName);
		System.out.println(PassWord);
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.quit();
	}
}