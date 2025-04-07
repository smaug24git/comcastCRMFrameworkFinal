package com.comcast.crm.ORutility;

/**
 * @author SANU
 * 
 * contains Oppertunityconfermationpage elements
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OpportunityConfemationPage {
	
	/*
	 * initialization of webelements
	 */
	WebDriver driver;

	public OpportunityConfemationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/*
	 * storing all elements of oppertunityconfermationpage using @FindBy annotation
	 * and providing encapsulation
	 */
	@FindBy(id = "dtlview_Opportunity Name")
	private WebElement oppoName;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement header;
	
	

	/*
	 * Providing Only Getters() method
	 */
	public WebElement getoppoName() {
		return oppoName;
	}

	public WebElement getheader() {
		return header;
	}

}
