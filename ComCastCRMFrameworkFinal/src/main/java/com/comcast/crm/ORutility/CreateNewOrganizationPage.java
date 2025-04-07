package com.comcast.crm.ORutility;

/**
 * @author SANU
 * 
 * contains createneworganizationpage elements and also
 * business librerirs like createorganization overloaded methods
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {

	/*
	 * initialization of webelements
	 */
	WebDriver driver;

	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/*
	 * storing all elements of CreateNewOrganizationpage page using @FindBy
	 * annotation and providing encapsulation
	 */

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgName;

	@FindBy(name = "phone")
	private WebElement phNum;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(name = "accounttype")
	private WebElement industryTypeDD;
	
	

	/*
	 * Providing Only Getters() method
	 */

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPhoneNum() {
		return phNum;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getIndustryTypeDD() {
		return industryTypeDD;
	}
	
	

	/**
	 * create organization based on Organization mane
	 * 
	 * @param orgname
	 */

	public void createOrg(String orgname) {
		orgName.sendKeys(orgname);
		savebtn.click();
	}

	/**
	 * create organization based on organization name, industry name and industry
	 * type
	 * 
	 * @param orgname
	 * @param industry
	 * @param industryType
	 */
	public void createOrg(String orgname, String industry, String industryType) // ==========Oveloaded business
																				// methods==========
	{

		orgName.sendKeys(orgname);

		Select s = new Select(industryDD);
		s.selectByVisibleText(industry);
		Select s1 = new Select(industryTypeDD);
		s1.selectByVisibleText(industryType);
		savebtn.click();

	}

	/**
	 * create organization based on organization name and phone number
	 * 
	 * @param orgname
	 * @param PhoneNum
	 */
	public void createOrg(String orgname, String PhoneNum) // ==========Oveloaded business methods==========
	{

		orgName.sendKeys(orgname);
		phNum.sendKeys(PhoneNum);

		savebtn.click();

	}

}
