package grid;

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
public class CreatecontactwithOrgTest extends Baseclass {
	
	@Test(groups = "RegressionTest")
	public void createContactwithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {

		/* step 1: geneating random numbes */
		UtilityClassObject.getTest().log(Status.INFO, "geneating random numbes");

		JavaUtility jLib = new JavaUtility();
		int randomNum = jLib.getRandomNumber(); 

		/* step 2: getting data om excel sheet */
		UtilityClassObject.getTest().log(Status.INFO, "Getting data from excel sheet");

		ExcelUtility eLib = new ExcelUtility();
		String org_name = eLib.getDataFromExcel("Sheet4", 7, 2).toString() + randomNum;
		String lastname = eLib.getDataFromExcel("Sheet4", 7, 3).toString();

		UtilityClassObject.getTest().log(Status.INFO, "Creating contact with organization");

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
		ccp.createContactwithORG(lastname);

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
