package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;

	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By popup = By.xpath("//button[text()='NO THANKS']");

	public landingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getlogin() {
		return driver.findElement(signin);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
	public int getpopupsize() {
		return driver.findElements(popup).size();
	}
	public WebElement getpopup() {
		return driver.findElement(popup);
	}

}
