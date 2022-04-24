package com.com.autodesk.Organization.Test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.com.autodesk.Elementrepository.CreateOrganizationPage;
import com.com.autodesk.Elementrepository.HomePage;
import com.com.autodesk.Elementrepository.OrganizationInfoPage;
import com.com.autodesk.Elementrepository.OrganizationsPage;
import com.crm.autodesk.GenericUtilities.BaseClass;

public class TC_03_CreateOrganizationWithAssignedToGroupTest extends BaseClass{

	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createOrganizationWithAssignedToGroupTest() throws Throwable {
		
		String OrgName = efu.getExcelData("Contact", 1, 4);
		String MarGroup = efu.getExcelData("Contact", 1, 6);
		
		// Navigate Organization page
		HomePage hm = new HomePage(driver);
		hm.clickonOrgnization();
		
		// Navigate to CreateOrganization page
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateOrgImg();
		
		//Create Organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrganizationWithAssignedToMarketingGroup
		(OrgName+ju.getRandomNum(), MarGroup);
		
		//Verification
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String value = oip.getOrganizationsInformaton();
		
		wdu.checkContainsHardAssertion(value, OrgName);
		System.out.println(OrgName);
		
		Reporter.log("Verification Success",true);
		
	}
}
