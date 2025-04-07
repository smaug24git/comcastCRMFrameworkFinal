package com.comcast.crm.ORutility;

/**
 * @author SANU
 * 
 * contains oppertunitypopup page elements
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppotunityPopupPage {
	/*
	 * initialization of webelements
	 */
	WebDriver driver;

	public OppotunityPopupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/*
	 * storing all elements of oppertunitypopuppage  using @FindBy annotation
	 * and providing encapsulation
	 */

	@FindBy(id = "search_txt")
	private WebElement searchtxtifeld;

	@FindBy(name = "search")
	private WebElement searchBtn;
	
	

	/*
	 * Providing Only Getters() method
	 */
	public WebElement getsearchtxtifeld() {
		return searchtxtifeld;
	}

	public WebElement getsearchBtn() {
		return searchBtn;
	}

}
