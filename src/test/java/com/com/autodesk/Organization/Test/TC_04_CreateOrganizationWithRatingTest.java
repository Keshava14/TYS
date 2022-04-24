package com.com.autodesk.Organization.Test;

import org.testng.annotations.Test;

import com.com.autodesk.Elementrepository.CreateOrganizationPage;
import com.com.autodesk.Elementrepository.HomePage;
import com.com.autodesk.Elementrepository.OrganizationsPage;
import com.crm.autodesk.GenericUtilities.BaseClass;

public class TC_04_CreateOrganizationWithRatingTest extends BaseClass {

	@Test(groups = {"SmokeSuite"})
	public void createOrganizationWithRatingTest() throws Throwable {
		
		String OrgName = efu.getExcelData("Contact", 1, 4);
		String ActiveRating = efu.getExcelData("Contact", 1, 7);
				
		// Navigate Organization page
		HomePage hp = new HomePage(driver);
		hp.clickonOrgnization();
		
		// Navigate to CreateOrganization page
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateOrgImg();
		
		//Create Organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrganizationWithRating
		(OrgName+ju.getRandomNum(), ActiveRating);
		
	}
}
