package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import resources.base;

public class validateNavigationBar extends base {
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver= initializeDriver();
		log.info("driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");
	}
	
	@Test
	public void basepageNavigationTest(){
		log.info("Test started");
		landingPage lpage= new landingPage(driver);
		boolean actualtext1= lpage.getNavBar().isDisplayed();
		Assert.assertTrue(actualtext1);
		log.info("Test completed and validated with actual text successfully.");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
