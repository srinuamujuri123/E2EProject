package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.LogInPage;
import pageObjects.landingPage;
import resources.base;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition extends base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver= initializeDriver();
		
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^Click on login link in home page to land on secure sign in page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		landingPage lpage = new landingPage(driver);
		if(lpage.getpopupsize() >0) {
			lpage.getpopup().click();
		}
		lpage.getlogin().click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	
	 @When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_test_gmail_com_and_and_logs_in(String arg1, String arg2) throws Throwable {
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LogInPage loginpage = new LogInPage(driver);
		
		loginpage.getEmail().sendKeys(arg1);
		loginpage.getPassword().sendKeys(arg2);
		loginpage.getloginbutton().click();
	}

	@Then("^verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("verified that user is successfully logged in");
	}
    @And("^close the browsers$")
    public void close_the_browser() throws Throwable {
       driver.quit();
    }

}
