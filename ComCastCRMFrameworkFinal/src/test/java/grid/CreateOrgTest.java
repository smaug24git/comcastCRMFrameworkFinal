package grid;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
	
	@Test
	public void createorgtest() throws EncryptedDocumentException, IOException
	{
	

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
}