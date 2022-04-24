package com.com.autodesk.Elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtilities.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{

	WebDriver driver;
	
	//constructor
	public CreateOrganizationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//locate all elements
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;

	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement assignedToGroupbtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement assignedToDropDown;
		
	@FindBy(name="rating")
	private WebElement ratingDropDown;
		
	@FindBy(name="notify_owner")
	private WebElement notifyownerCheckbox;
	
	@FindBy(xpath ="(//input[@type='checkbox'])[2]")
	private WebElement notifyownerCheckboxUnclick;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//provide getters
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	// Business logic 1
	/**
	 *  This method will create Organization with Organization name
	 * @param OrgName
	 */
	
	public void createOrganization(String OrgName) {
		OrgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}

	//Business logic 2
	/**
	 * This method will create Organization by choosing as industry type
	 * @param OrgName
	 * @param indType
	 */
	public void createOrganizationWithIndustry(String OrgName, String indType) {
		OrgNameEdt.sendKeys(OrgName);
		select(industryDropDown, indType);	
		saveBtn.click();
	}
	
	//Business logic 3
	/**
	 * This method will create Organization by choosing as Assigned to Group radio btn
	 * @param OrgName
	 * @param MarGroup
	 */
	public void createOrganizationWithAssignedToMarketingGroup
	(String OrgName, String MarGroup)
	{
		OrgNameEdt.sendKeys(OrgName);
		assignedToGroupbtn.click();
		select(assignedToDropDown, MarGroup);
		saveBtn.click();
	}
	
	// Business logic 4
	/**
	 * This method will create Organization by choosing Organization With Rating
	 * @param OrgName
	 * @param ActiveRating
	 */
	public void createOrganizationWithRating(String OrgName, String ActiveRating) {
		OrgNameEdt.sendKeys(OrgName);
		select(ratingDropDown, ActiveRating);
		saveBtn.click();
	}

	// Business logic 5
	/**
	 * This method will create Organization by clicking Notify checkbox
	 * @param OrgName
	 */
	public void createOrganizationWithNotify(String OrgName) {
		OrgNameEdt.sendKeys(OrgName);
		notifyownerCheckbox.click();
		saveBtn.click();
	}
	/**
	 * This method will check Notify checkbox enabled or not
	 */
	public void checkBoxSelected() {
		
		if(notifyownerCheckbox.isSelected()) 
		{
			System.out.println("notifyownerCheckbox Enabled");
		}else {
			System.out.println("notifyownerCheckbox Disabled");
			notifyownerCheckbox.click();
		}
	}
	/**
	 * this method checking DropDown working or not
	 */
	public void checkDropdown() {
		if(ratingDropDown.isSelected()) 
		{
			System.out.println("DropDown Displayed");
		}else {
			System.out.println("DropDown not Displayed");
			ratingDropDown.click();
		}
	}
	
	/**
	 * This method will create Organization by clicking save buttton
	 */
	public void saveButton() {
		saveBtn.click();
	}
	
}
