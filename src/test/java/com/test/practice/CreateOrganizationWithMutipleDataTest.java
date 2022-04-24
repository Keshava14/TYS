package com.test.practice;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.com.autodesk.Elementrepository.CreateOrganizationPage;
import com.com.autodesk.Elementrepository.HomePage;
import com.com.autodesk.Elementrepository.OrganizationInfoPage;
import com.com.autodesk.Elementrepository.OrganizationsPage;
import com.crm.autodesk.GenericUtilities.BaseClass;

public class CreateOrganizationWithMutipleDataTest extends BaseClass{
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		
		return efu.getExcelData("organization");	
	}
	@Test(dataProvider = "getData")
	public void createOrganizationWithMultipleData(String OrgName, String IndType) throws Throwable {
			
		//String OrganizationName = efu.getExcelData("Organization", 1, 1) + ju.getRandomNum();

		HomePage hp = new HomePage(driver);
		hp.clickonOrgnization();
		Reporter.log("Org link has beeb clicked");
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateOrgImg();
		Reporter.log("create Org link has beeb clicked");
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrganizationWithIndustry(OrgName+ju.getRandomNum(), IndType);
		Reporter.log("Organization has been created");
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgInfo = oip.getOrganizationsInformaton();
		wdu.checkContainsHardAssertion(actualOrgInfo, OrgName);
		System.out.println(OrgName);
		hp.signout(driver);

		Reporter.log("Verification sucess", true);

	}
}
