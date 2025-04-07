package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Gridsampletest {
	@Test
	public void sample()
	{
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}

}
