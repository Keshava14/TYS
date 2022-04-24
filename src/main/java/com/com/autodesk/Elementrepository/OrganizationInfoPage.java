package com.com.autodesk.Elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

		//constructor
		public OrganizationInfoPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		//locate all elements
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement organizationInfo;
		
		@FindBy(id = "dtlview_Industry")
		private WebElement industryInfo;

		// provide getters
		public WebElement getOrganizationInfo() {
			return organizationInfo;
		}

		public WebElement getIndustryInfo() {
			return industryInfo;
		}
		
		/**
		 * get organization information
		 */
		public String getOrganizationsInformaton() {
			String value = organizationInfo.getText();
			return value;
		}
		/**
		 * get industry information
		 */
		public String getIndustriesInfo() {
			
			return industryInfo.getText();	
		}
	
}
