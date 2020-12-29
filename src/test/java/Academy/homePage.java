package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LogInPage;
import pageObjects.landingPage;
import resources.base;

public class homePage extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver= initializeDriver();
		log.info("webdriver initialised");
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException{
		
		driver.get(prop.getProperty("url"));
		log.info("home page initialised");
		landingPage lpage = new landingPage(driver);
		lpage.getlogin().click();
		LogInPage loginpage = new LogInPage(driver);
		loginpage.getEmail().sendKeys(username);
		loginpage.getPassword().sendKeys(password);
		loginpage.getloginbutton().click();
		log.info(text);
		log.info("test completed successfully");
	
	

	}
	
	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][3];

		data[0][0] = "restricteduser@gmail.com";
		data[0][1] = "13456";
		data[0][2] = "datasent1time";

		data[1][0] = "nonrestricteduser@gmail.com";
		data[1][1] = "1245875";
		data[1][2] = "datasent2ndtime";

		return data;

	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
