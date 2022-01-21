package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		// PageFactory method use when we use #FindBy Selenium Annotation.
	}
	
	@FindBy(xpath="//a[contains (@href, 'sign_in')]")
	WebElement Login;
	
	// OR
	
	By login = By.xpath("//a[contains (@href, 'sign_in')]");
	
	
	// NullPointexeception -> pointer error. invoking method from null objects.
	//                        taking length of null, when you are trying to use null objects
	// NoSuchElementException -> when there is no element found.
	// NoSuchFileException -> when there is no file found
	
	@FindBy(xpath="//div[@class='text-center']/a")
	WebElement btntxt;
	
	@FindBy(xpath="//nav[contains (@class, 'navbar-collapse')]/ul/li")
	WebElement navbar;

	public WebElement getLogin()
	{
//		return Login;
		return driver.findElement(login);
	}
	
	public WebElement btntxt() {
		return btntxt;
	}
	
	public WebElement navbaelement() {
		return navbar;
	}

}
