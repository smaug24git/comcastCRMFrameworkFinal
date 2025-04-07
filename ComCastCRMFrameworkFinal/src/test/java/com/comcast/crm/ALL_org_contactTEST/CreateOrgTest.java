package com.comcast.crm.ALL_org_contactTEST;
/**
 * 
 * @author SANU
 * 
 * test class for Organization module
 * contains CreateOrgTest(), OrgwithPhoneNum(), OrgwithIndustry() test cases
 */

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BASEclassUtility.Baseclass;
import com.comcast.crm.ORutility.CreateNewOrganizationPage;
import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.OrganizationInformationPage;
import com.comcast.crm.ORutility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;


@Listeners(com.comcast.crm.listenerUtility.ListeneImp.class)
public class CreateOrgTest extends Baseclass {
	
	/**
	 * scenario::
	 * login to app==>goto organization module==>create organization with organization name==> verify with assert ==>logout of app
	 * 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	@Test (groups = "SmokeTest")
	public void OrgTest() throws EncryptedDocumentException, IOException {

		
		 /*geneating random numbes*/ 
		UtilityClassObject.getTest().log(Status.INFO, "geneating random numbes");
		
		JavaUtility jLib = new JavaUtility();     
		int randomNum = jLib.getRandomNumber();
		
		 /*getting data om excel sheet*/ 
		UtilityClassObject.getTest().log(Status.INFO, "Getting data from excel sheet");
		
		ExcelUtility eLib = new ExcelUtility();  
		String org_name = eLib.getDataFromExcel("Sheet3", 1, 2) + randomNum;
		
		  /*creating orgTest*/ 
		UtilityClassObject.getTest().log(Status.INFO, "creating OrgTest ");
		
		HomePage hp = new HomePage(driver);           
		hp.getOrglink().click();
		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.getOrgImg().click();
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(org_name);
		
		  /*verification with assertion*/
		UtilityClassObject.getTest().log(Status.INFO, "verification with assertion");
		
		OrganizationInformationPage orginfopage = new OrganizationInformationPage(driver);  
		String actorgInfo = orginfopage.getHeaderMsg().getText();
		boolean orgInfo_verify = actorgInfo.contains(org_name);
		Assert.assertTrue(orgInfo_verify);
	}
	
	/**
	 * scenario::
	 * login to app==>goto organization module==>create organization with organization name and phone number
	 * ==> verify with assert ==>logout of app
	 * 
	 * @throws Throwable
	 * @throws IOException
	 */

	@Test(groups = "RegressionTest")
	public void OrgwithPhoneNum() throws Throwable, IOException {

		 /*geneating random numbes*/ 
		UtilityClassObject.getTest().log(Status.INFO, "geneating random numbes");
		
		JavaUtility jLib = new JavaUtility();    
		int randomNum = jLib.getRandomNumber();
 
		 /*getting data om excel sheet*/ 
		UtilityClassObject.getTest().log(Status.INFO, "Getting data from excel sheet");
		
		ExcelUtility eLib = new ExcelUtility();   
		String org_name = eLib.getDataFromExcel("Sheet3", 4, 2).toString() + randomNum;
		String phone_no = eLib.getDataFromExcel("Sheet3", 7, 3).toString();
		
		 /*creating orgwithContactTest*/ 
		UtilityClassObject.getTest().log(Status.INFO, "creating OrgwithContactTest ");
		
		HomePage hp = new HomePage(driver);          
		hp.getOrglink().click();
		OrganizationsPage orgpage = new OrganizationsPage(driver);  
		orgpage.getOrgImg().click();
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);  
		cnp.createOrg(org_name, phone_no);
		
		  /*verification with assertion*/
		UtilityClassObject.getTest().log(Status.INFO, "verification with assertion");
		
		OrganizationInformationPage orginfopage = new OrganizationInformationPage(driver); 
		String actorgInfo = orginfopage.getHeaderMsg().getText();
		boolean orgInfo_verify = actorgInfo.contains(org_name);
		Assert.assertTrue(orgInfo_verify);

	}
	
	/**
	 * scenario::
	 * login to app==>goto organization module==>create organization with organization name ,industry name and industry type
	 * ==> verify with assert ==>logout of app
	 * 
	 * @throws Throwable
	 * @throws IOException
	 */

	@Test(groups = "RegressionTest")
	public void OrgwithIndustry() throws Throwable, IOException {
		
		 /*geneating random numbes*/ 
		UtilityClassObject.getTest().log(Status.INFO, "geneating random numbes");
		
		JavaUtility jLib = new JavaUtility();    
		int randomNum = jLib.getRandomNumber();
		
		 /*getting data om excel sheet*/ 
		UtilityClassObject.getTest().log(Status.INFO, "Getting data from excel sheet");
		
		ExcelUtility eLib = new ExcelUtility();
		String org_name = eLib.getDataFromExcel("Sheet3", 1, 2) + randomNum;   
		String industry_name = eLib.getDataFromExcel("Sheet3", 4, 3).toString();
		String industry_type = eLib.getDataFromExcel("Sheet3", 4, 4).toString();
		

		 /*creating orgwithIndustryTest*/ 
		UtilityClassObject.getTest().log(Status.INFO, "creating OrgwithIndustryTest ");
		
		HomePage hp = new HomePage(driver);               
		hp.getOrglink().click();
		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.getOrgImg().click();
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createOrg(org_name, industry_name, industry_type);

		  /*verification with assertion*/
		UtilityClassObject.getTest().log(Status.INFO, "verification with assertion");
		OrganizationInformationPage orginfo = new OrganizationInformationPage(driver); 
		
		String actIndustry = orginfo.getIndustry().getText();
		boolean Industry_verify = actIndustry.equals(industry_name);
		SoftAssert soft= new SoftAssert();
		soft.assertTrue(Industry_verify);
		
		String actIndustryType = orginfo.getIndustrytype().getText();
		boolean IndustryType_verify = actIndustryType.equals(industry_type);
		soft.assertTrue(IndustryType_verify);
		

	}
}
