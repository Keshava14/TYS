package com.test.practice;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.JSON_FileUtility;

public class RemoteExecution {

	@Test
	public void remoteExecutionTest() throws Throwable {
		
		JSON_FileUtility jfu = new JSON_FileUtility();
		
		String Browser = jfu.readDataFromJSON("Browser");
		
		URL url = new URL("http://18.224.213.207:6666/wd/hub");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(Browser.equals("chrome")) {
			cap.setPlatform(Platform.WINDOWS);
			cap.setBrowserName("chrome");
		}
		else if(Browser.equals("firefox")) {
			cap.setPlatform(Platform.WINDOWS);
			cap.setBrowserName("firefox");
		}
		else {
			System.out.println("Browser not Found");
		}
		RemoteWebDriver driver = new RemoteWebDriver(url,cap);
		driver.get("http://gmail.com");
		System.out.println("Browser Launch Successfully");

	}
}



