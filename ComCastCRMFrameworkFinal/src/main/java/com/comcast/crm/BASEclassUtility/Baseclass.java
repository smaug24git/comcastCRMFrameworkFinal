package com.comcast.crm.BASEclassUtility;

/**
 * 
 * @author SANU
 * 
 *         contains TestNG configuration annotations. contains actions like
 *         connect to database, close the database connection, launching the
 *         browser, login to application,logout of application
 *
 */

import java.io.IOException;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.ORutility.HomePage;
import com.comcast.crm.ORutility.Loginpage;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;


public class Baseclass {

	public FileUtility flib = new FileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public DataBaseUtility dblib = new DataBaseUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriver driver = null; // =============> if we make this static it will not take part in parallel
									// execution

	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "SmokeTest", "RegressionTest" })
	public void beforesuit() {
		System.out.println("============DB connection=====");
		dblib.getDBconnection();
	}

	@BeforeTest(groups = { "SmokeTest", "RegressionTest" })
	public void beforetest() {

	}

	@BeforeClass(groups = { "SmokeTest", "RegressionTest" })

	public void beforeclass() throws IOException {
		System.out.println("=====launch Browser=========");

		String BROWSER = System.getProperty("browser",flib.getDatafromPropertiesFile("browser"));

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;

		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "SmokeTest", "RegressionTest" })
	public void loginpage() throws Throwable {
		
		System.out.println("======login to application=========");

		String URL = System.getProperty("url",flib.getDatafromPropertiesFile("url"));
		String USERNAME = System.getProperty("username",flib.getDatafromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password",flib.getDatafromPropertiesFile("password"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(17));
		driver.manage().window().maximize();
		driver.get(URL);

		Loginpage lp = new Loginpage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

	}

	@AfterMethod(groups = { "SmokeTest", "RegressionTest" })
	public void aftermethod() {
		System.out.println("=====LOGOUT OF APPLICATION=======");
		HomePage hp = new HomePage(driver);
		// hp.logout();
		hp.getsignout().click();
		hp.getsignoutlink().click();

	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void afterclass() {

		driver.quit();
	}

	@AfterTest(groups = { "SmokeTest", "RegressionTest" })
	public void aftertest() {

	}

	@AfterSuite(groups = { "SmokeTest", "RegressionTest" })
	public void aftersuit() throws SQLException {
		dblib.closeDBconnection();

	}

}
