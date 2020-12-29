package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	public WebDriver driver;

	By username = By.id("user_email");
	By password = By.id("user_password");
	By loginbutton = By.name("commit");

	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getloginbutton() {
		return driver.findElement(loginbutton);
	}

}
