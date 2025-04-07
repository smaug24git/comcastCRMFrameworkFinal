package com.comcast.crm.ORutility;

/**
 * @author SANU
 * 
 * contains organizationpage elements
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	/*
	 * initialization of webelements
	 */

	WebDriver driver;

	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/*
	 * storing all elements of organizationpage page using @FindBy annotation
	 * and providing encapsulation
	 */

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']") 
	private WebElement orgimg;
	
	

	/*
	 * Providing Only Getters() method
	 */

	public WebElement getOrgImg() {
		return orgimg;

	}

}
