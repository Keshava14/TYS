package com.com.autodesk.Organization.Test;

import org.testng.annotations.Test;

import com.com.autodesk.Elementrepository.CreateOrganizationPage;
import com.com.autodesk.Elementrepository.HomePage;
import com.com.autodesk.Elementrepository.OrganizationsPage;
import com.crm.autodesk.GenericUtilities.BaseClass;

public class TC_06_CheckingNotifyCheckBoxEnabledOrNotTest extends BaseClass {

	@Test
	public void checkingNotifyCheckBoxEnabledOrNotTest() throws Throwable {

		String OrgName = efu.getExcelData("Contact", 1, 4);

		// Navigate Organization page
		HomePage hm = new HomePage(driver);
		hm.clickonOrgnization();

		// Navigate to CreateOrganization page
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateOrgImg();

		//Create Organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.checkBoxSelected();	

	}

}
