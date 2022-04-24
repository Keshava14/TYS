package com.com.autodesk.Organization.Test;

import org.testng.annotations.Test;

import com.com.autodesk.Elementrepository.CreateOrganizationPage;
import com.com.autodesk.Elementrepository.HomePage;
import com.com.autodesk.Elementrepository.OrganizationsPage;
import com.crm.autodesk.GenericUtilities.BaseClass;

public class TC_07_CheckingOrganizationWithRatingDropDownTest extends BaseClass {

	@Test(groups = {"SmokeSuite"})
	public void checkingOrganizationWithRatingDropDownTest() throws Throwable {
			
		// Navigate Organization page
		HomePage hp = new HomePage(driver);
		hp.clickonOrgnization();
		
		// Navigate to CreateOrganization page
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateOrgImg();
		
		//Create Organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.checkDropdown();


	}
}
