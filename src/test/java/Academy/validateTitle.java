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

public class validateTitle extends base {
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
	public void basepageNavigation1Test(){
		log.info("Test started");
		landingPage lpage= new landingPage(driver);
		String actualtext=lpage.getTitle().getText();
		Assert.assertEquals(actualtext, "FEATURED COURSES");	
		log.info("Test completed and validated with actual text successfully.");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		
	}
	
	
	

}
