package com.comcast.crm.ALL_org_contactTEST;

/**
 * 
 * @author SANU 
 * 
 *    test class for Contact module contains Createcontact() ,
 *    createContactwithOrgTest(), createContactwithsupportdateTest() test cases
 */
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BASEclassUtility.Baseclass;
import com.comcast.crm.ORutility.ContactInformationPage;
import com.comcast.crm.ORutility.ContactsPage;
import com.comcast.crm.ORutility.CreateNewContactPage;
import com.comcast.crm.ORutility.CreateNewOrganizationPage;
import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.OrgPopUpPage;
import com.comcast.crm.ORutility.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;


@Listeners(com.comcast.crm.listenerUtility.ListeneImp.class)
public class CreatecontactTest extends Baseclass {
	
	/**scenario::
	 * login to app==>goto contact module==>create contact with last name==> verify with assert ==>logout of app
	 * 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	@Test(groups = "SmokeTest")
	public void createContact() throws EncryptedDocumentException, IOException {

		/* step 1: geneating random numbes */
		UtilityClassObject.getTest().log(Status.INFO, "geneating random numbes");

		JavaUtility jLib = new JavaUtility();
		int randomNum = jLib.getRandomNumber();

		/* step 2: getting data om excel sheet */
		UtilityClassObject.getTest().log(Status.INFO, "Getting data from excel sheet");

		ExcelUtility eLib = new ExcelUtility();
		String last_name = eLib.getDataFromExcel("Sheet3", 1, 2).toString() + randomNum;

		/* step 3: creating ContactwithLastNameTest */
		UtilityClassObject.getTest().log(Status.INFO, "creating ContactwithLastNameTest ");

		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getOrgImg().click();
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContact(last_name);
		ContactInformationPage cip = new ContactInformationPage(driver);

		/* step 4: verification with assertion */
		UtilityClassObject.getTest().log(Status.INFO, "verification with assertion");

		String actualheader = cip.getContactheader().getText();
		boolean header_verify = actualheader.contains(last_name);
		Assert.assertTrue(header_verify);

		String actlastname = cip.getLstname().getText();
		boolean name_verify = actlastname.trim().equals(last_name);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(name_verify);

	}
	
	
	/**
	 * scenario::
	 * login to app==>goto contact module==>create contact with start date and end  date==> verify with assert ==>logout of app
	 * 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	@Test(groups = "RegressionTest")
	public void createContactwithsupportdateTest() throws EncryptedDocumentException, IOException {

		/* step 1: geneating random numbes */
		UtilityClassObject.getTest().log(Status.INFO, "geneating random numbes");

		JavaUtility jLib = new JavaUtility();
		int randomNum = jLib.getRandomNumber();

		/* step 2: getting data om excel sheet */
		UtilityClassObject.getTest().log(Status.INFO, "Getting data from excel sheet");

		ExcelUtility eLib = new ExcelUtility();
		String last_name = eLib.getDataFromExcel("Sheet3", 1, 2).toString() + randomNum;

		/* step 3: getting Start and End date */
		UtilityClassObject.getTest().log(Status.INFO, "Getting start and end date");

		String start_date = jLib.getSystemDate();
		String end_date = jLib.getReqiuredDate(30);

		/* step 4: creating ContactwithsupportDateTest */
		UtilityClassObject.getTest().log(Status.INFO, "creating ContactwithsupportDateTest ");

		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getOrgImg().click();
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContact(last_name, start_date, end_date);
		ContactInformationPage cip = new ContactInformationPage(driver);

		/* step 5: verification with assertion */
		UtilityClassObject.getTest().log(Status.INFO, "verification with assertion");

		String actStrtdate = cip.getStrtdate().getText();
		boolean Strtdate_verify = actStrtdate.trim().equals(start_date);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(Strtdate_verify); //

		String actEnddate = cip.getEnddate().getText();
		boolean Enddate_verify = actEnddate.trim().equals(end_date);
		soft.assertTrue(Enddate_verify);

	}
	
	/**
	 * 
	 * scenario::
	 * login to app==>goto contact module==>create contact with last name and Organization name==> verify with assert ==>logout of app
	 * 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Test(groups = "RegressionTest")
	public void createContactwithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {

		/* step 1: geneating random numbes */
		UtilityClassObject.getTest().log(Status.INFO, "geneating random numbes");

		JavaUtility jLib = new JavaUtility();
		int randomNum = jLib.getRandomNumber();

		/* step 2: getting data om excel sheet */
		UtilityClassObject.getTest().log(Status.INFO, "Getting data from excel sheet");

		ExcelUtility eLib = new ExcelUtility();
		String org_name = eLib.getDataFromExcel("Sheet3", 7, 2).toString() + randomNum;
		String lastname = eLib.getDataFromExcel("Sheet3", 7, 3).toString();

		/* step 3: Creating Object With support date */
		UtilityClassObject.getTest().log(Status.INFO, "Creating Object With support date");

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrganizationsPage orgpage = new OrganizationsPage(driver);
		orgpage.getOrgImg().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(org_name);

		Thread.sleep(3000);

		/* step 4: Creating ContactwithOrg */
		UtilityClassObject.getTest().log(Status.INFO, "Creating ContactwithOrg");

		HomePage hp1 = new HomePage(driver);
		hp1.getContactlink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getOrgImg().click();
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContact(lastname);

		/* switch to child window */
		UtilityClassObject.getTest().log(Status.INFO, "switch to child window");
		wlib.switchToTabOnURL(driver, "module=Accounts");

		OrgPopUpPage op = new OrgPopUpPage(driver);
		op.orgpopup(org_name);
		driver.findElement(By.xpath("//a[text()='" + org_name + "']")).click();

		/* switch back to paent window */
		UtilityClassObject.getTest().log(Status.INFO, "switch back to paent window");
		wlib.switchToTabOnURL(driver, "module=Contacts");

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actContactHeader = cip.getContactheader().getText();

		/* step 5: verification with assertion */
		UtilityClassObject.getTest().log(Status.INFO, "verification with assertion");

		boolean ContactHeader_verify = actContactHeader.trim().contains(lastname);
		Assert.assertTrue(ContactHeader_verify);

		String actPopupOrgName = cip.getPopOrgname().getText();
		boolean PopupOrgName_verify = actPopupOrgName.trim().equals(org_name);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(PopupOrgName_verify);

	}

}
