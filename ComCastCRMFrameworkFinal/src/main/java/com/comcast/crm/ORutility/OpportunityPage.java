package com.comcast.crm.ORutility;
/**
 * @author SANU

 * 
 * contains oppertunitypage elements 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class OpportunityPage {
	/*
	 * initialization of webelements
	 */
		WebDriver driver;
	
	public OpportunityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	/*
	 * storing all elements of oppertunitypage page using @FindBy annotation
	 * and providing encapsulation
	 */
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement opportunityImg;
	
	
	
	/*
	 * Providing Only Getters() method
	 */
	public WebElement getopportunityImg()
	{
		return opportunityImg;
	}

}
