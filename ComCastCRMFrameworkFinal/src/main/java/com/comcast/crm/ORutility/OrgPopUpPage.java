package com.comcast.crm.ORutility;

/**
 * @author SANU
 * 
 * Contains organizationpopuppage elements
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPopUpPage {

	/*
	 * initialization of webelements
	 */
	WebDriver driver;

	public OrgPopUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * storing all elements of OrgPopUpPage using @FindBy annotation
	 *and providing encapsulation
	 */

	@FindBy(id = "search_txt")
	private WebElement search;

	@FindBy(name = "search")
	private WebElement searchbtn;

	/*
	 * Providing Only Getters() method
	 */

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

/**
 * selecting organization based on organization name
 * @param orgname
 */

	public void orgpopup(String orgname) {
		search.sendKeys(orgname);
		searchbtn.click();
	}

}
