package com.comcast.crm.ORutility;

/**
 * @author SANU
 * 
 * contains contact page elements 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	/*
	 * initialization of webelements
	 */
	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/*
	 * storing all elements of contactpage page using @FindBy annotation
	 * and providing encapsulation
	 */

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']") // themes/softed/images/btnL3Add.gif
	private WebElement contactimg;
	
	

	/*
	 * Providing Only Getters() method
	 */

	public WebElement getOrgImg() {
		return contactimg;

	}

}
