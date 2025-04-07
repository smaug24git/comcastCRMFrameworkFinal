package com.comcast.crm.ORutility;

/**
 * @author SANU
 * 
 * contains loginpage elements and business libreries like logout()
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	/*
	 * initialization of webelements
	 */

	WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // pagefactory.initElements(driver, Loginpage.class);
	}
	

	/*
	 * storing all elements of Loginpage page using @FindBy
	 * annotation and providing encapsulation
	 */

	@FindBy(name = "user_name")
	private WebElement un;

	@FindBy(name = "user_password")
	private WebElement psw;

	@FindBy(id = "submitButton")
	private WebElement clickbtn;
	
	

	/*
	 * Providing Only Getters() method
	 */

	public WebElement getusename() {
		return un;
	}

	public WebElement getpassword() {
		return psw;
	}

	public WebElement getloginbtn() {
		return clickbtn;
	}
	
	

	/**
	 * login to application using username and password
	 * 
	 * @param userName
	 * @param passWord
	 */

	public void loginToApp(String userName, String passWord) {

		un.sendKeys(userName);
		psw.sendKeys(passWord);
		clickbtn.click();
	}

}
