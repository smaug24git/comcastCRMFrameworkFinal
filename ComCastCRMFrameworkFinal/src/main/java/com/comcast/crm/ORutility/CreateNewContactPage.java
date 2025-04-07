package com.comcast.crm.ORutility;

/**
 * @author SANU
 * 
 * contains CreateNewcontactpage elements and business libreries like createcontact overloaded mothods
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	/*
	 * initialization of webelements
	 */
	WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/*
	 * storing all elements of CreateNewcontactpage page using @FindBy annotation
	 */

	@FindBy(name = "lastname")
	private WebElement lstname;

	@FindBy(name = "support_start_date")
	private WebElement strtDate;

	@FindBy(name = "support_end_date")
	private WebElement endDate;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement addorgICON;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	

	/*
	 * Providing Only Getters() method
	 */

	public WebElement getLstname() {
		return lstname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getStrtDate() {

		return strtDate;
	}

	public WebElement getEndDate() {

		return endDate;
	}

	public WebElement addORG() {
		return addorgICON;
	}

	
	
	/**
	 * create contact based on lastname
	 * 
	 * @param lastname
	 */

	public void createContact(String lastname) {
		lstname.sendKeys(lastname);
		savebtn.click();
	}

	/**
	 * create contact based on lastname,start date, required date
	 * 
	 * @param lastname
	 * @param sdate
	 * @param edate
	 */

	public void createContact(String lastname, String sdate, String edate) {
		lstname.sendKeys(lastname);
		strtDate.clear();
		strtDate.sendKeys(sdate);
		endDate.clear();
		endDate.sendKeys(edate);
		savebtn.click();

	}

}
