package com.comcast.crm.generic.webdriverutility;

/**
 * 
 * @author SANU

 * test class releted to Browser instacne and Extent report
 * uses ThreadLocal so that both browser-instance and extent-test can participate in parallel execution 
 * without any error by creating mutiple static copy.
 *
 */
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {

	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	// getter test
	public static ExtentTest getTest() {
		return test.get();
	}

	// setter test
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}

	// getter driver
	public static WebDriver getDriver() {
		return driver.get();
	}

	// setter driver
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}
}
