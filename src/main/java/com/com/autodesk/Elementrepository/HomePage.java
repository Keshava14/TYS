package com.com.autodesk.Elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.autodesk.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	//constructor
		public HomePage(WebDriver driver) {
			
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
//	@FindBy(xpath ="//span[@class='userName' and 'Sign Out']")
	@FindBy(xpath ="//a[text()='Sign Out']")
	private WebElement signoutLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;

	@FindBy(linkText = "Email")
	private WebElement emailLnk;

	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
		
	public WebElement getOrganisationLnk() {
		return organizationsLnk;
	}
	public WebElement getAdminstratorImg() {
		return administratorImg;
	}
	public WebElement getSignoutLnk() {
		return signoutLnk;
	}	
	public WebElement getContactsLnk() {
		return contactsLnk;
	}
	public WebElement getProductsLnk() {
		return productsLnk;
	}
	public WebElement getEmailLnk() {
		return emailLnk;
	}
	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}
	public void mouseover(WebDriver driver,String element) {
		mouseOver(driver, administratorImg);
	}
	public void signout(WebDriver driver) {
		mouseOver(driver, administratorImg);
		waitForElementVisibility(driver, administratorImg);
		signoutLnk.click();
	}
	public void clickonLeads() {
		leadsLnk.click();
	}
	
	public void clickonOrgnization() {
		organizationsLnk.click();
	}
	public void switchParent(WebDriver driver) {
		switchToWindow(driver, "Marketing");
	}

}
