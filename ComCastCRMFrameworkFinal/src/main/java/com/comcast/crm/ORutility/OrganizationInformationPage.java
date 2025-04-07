package com.comcast.crm.ORutility;

/**
 * @author SANU
 * 
 * contains Organizationinformationpage elements 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {

	/*
	 * initialization of webelements
	 */

	WebDriver driver;

	public OrganizationInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * storing all elements of Organizationinformationpage  using @FindBy
	 * annotation and providing encapsulation
	 */

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;

	@FindBy(id = "mouseArea_Phone")
	private WebElement phoneNumber;

	@FindBy(id = "mouseArea_Industry")
	private WebElement industry;

	@FindBy(id = "mouseArea_Type")
	private WebElement industrytype;
	

	/*
	 * Providing Only Getters() method
	 */

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getIndustrytype() {
		return industrytype;
	}

}
