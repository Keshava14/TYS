package com.com.autodesk.Elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.autodesk.GenericUtilities.BaseClass2;

public class Flipkart_LoginPage extends BaseClass2{

	WebDriver driver;

	public Flipkart_LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[text()='✕']")
	private WebElement closepopup;

	@FindBy(linkText="Login")
	private WebElement loginButton;

	@FindBy(linkText="My Profile")
	private WebElement myprofile;

	@FindBy(className="_2IX_2- VJZDxU")
	private WebElement emailormobileno;

	@FindBy(xpath="//input[@type='password']")
	private WebElement password;

	@FindBy(xpath="//div[@class='_2YsvKq o8qAfl']/following-sibling::span[text()='Login']")
	private WebElement loginBtn;

	public void loginToApp() {

		try {
			closepopup.click();
			wdu.waitForPageLoad(driver);
			wdu.mouseOver(driver, myprofile);
			myprofile.click();
			wdu.switchToWindow(driver, "Online Shopping Site for Mobiles");
			System.out.println("clicked on myprofile");
			
		} catch (Exception e) {
			System.out.println("Not clicked on myprofile");
			Assert.fail();
		}
	}
	public void myprofile() {
		try {			
			emailormobileno.sendKeys("8106086517");
			password.sendKeys("8099980208");
			loginBtn.click();
			System.out.println("User deatils enterd");

		} catch (Exception e) {

			System.out.println("Not enterd User deatils ");
			Assert.fail();
		}
	}
	
}


