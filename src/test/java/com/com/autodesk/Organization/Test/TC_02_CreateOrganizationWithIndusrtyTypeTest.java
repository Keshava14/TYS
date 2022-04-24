package com.com.autodesk.Organization.Test;

import org.testng.annotations.Test;
import com.com.autodesk.Elementrepository.CreateOrganizationPage;
import com.com.autodesk.Elementrepository.HomePage;
import com.com.autodesk.Elementrepository.OrganizationsPage;
import com.crm.autodesk.GenericUtilities.BaseClass;

public class TC_02_CreateOrganizationWithIndusrtyTypeTest extends BaseClass {
	@Test
	public void createOrganizationTest() throws Throwable {
		
		String OrgName = efu.getExcelData("Contact", 1, 4);
		
		// Navigate Organization page
		HomePage hp = new HomePage(driver);
		hp.clickonOrgnization();

		// Navigate to CreateOrganization page
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateOrgImg();
		
		//Create Organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrganizationWithIndustry(OrgName+ju.getRandomNum(), "Education");		
		
	}
	
}
