package com.comcast.crm.ORutility;

/**
 * 
 * @author SANU
 * 
 * contains ContactInformation Page elements 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {

	/*
	 * initialization of webelements
	 */
	WebDriver driver;

	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	/*
	 * storing all elements of ContactInformation page using @FindBy annotation
	 * and providing encapsulation
	 */

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactheader;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement PopOrgname;

	@FindBy(id = "mouseArea_Last Name")
	private WebElement lstname;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement strtdate;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement enddate;
	
	

	/*
	 * Providing Only Getters() method
	 */

	public WebElement getContactheader() {
		return contactheader;
	}

	public WebElement getPopOrgname() {
		return PopOrgname;
	}

	public WebElement getLstname() {
		return lstname;
	}

	public WebElement getStrtdate() {
		return strtdate;
	}

	public WebElement getEnddate() {
		return enddate;
	}

}
