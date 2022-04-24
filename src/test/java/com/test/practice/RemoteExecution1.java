package com.test.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteExecution1 {

	@Test
	public void remoteExecutionTest() throws MalformedURLException {
		
		URL url = new URL("http://18.224.213.207:6666/wd/hub");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver = new RemoteWebDriver(url,cap); 
		driver.get("http://gmail.com");
		System.out.println("Browser Launch Successfully");
	}

}
