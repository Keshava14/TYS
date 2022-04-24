package com.com.autodesk.Organization.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.com.autodesk.Elementrepository.CreateOrganizationPage;
import com.com.autodesk.Elementrepository.HomePage;
import com.com.autodesk.Elementrepository.OrganizationsPage;
import com.crm.autodesk.GenericUtilities.BaseClass;
 

@Listeners(com.crm.autodesk.GenericUtilities.Listeners.class)
public class TC_01_CreateOrganizationTest extends BaseClass {
	
	@Test(retryAnalyzer = com.crm.autodesk.GenericUtilities.RetryAnalyzer.class)
	public void createOrganisationTest() throws Throwable {
		
		String OrgName = efu.getExcelData("Contact", 1, 4);
		
		// Navigate Organization page
		HomePage hp = new HomePage(driver);
		hp.clickonOrgnization();

		// Navigate to CreateOrganization page
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateOrgImg();
		
		//Create Organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrganization(OrgName+ju.getRandomNum());
		
		Assert.assertEquals(true, false);

		
	}
}
