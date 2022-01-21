package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		// PageFactory method use when we use #FindBy Selenium Annotation.
	}
	
	@FindBy(css="input[id$='user_email']")
	WebElement email;
	// OR
	By Email = By.cssSelector("cssSelector");
	// NullPointexeception -> pointer error. invoking method from null objects.
	//                        taking length of null, when you are trying to use null objects
	// NoSuchElementException -> when there is no element found.
	// NoSuchFileException -> when there is no file found
	
	
	@FindBy(css="input[type='password']")
	WebElement pass;
	
	@FindBy(css="input[value='Log In']")
	WebElement loginbtn;

	public WebElement getEmail()
	{
//		return Login;
		return email;  // PageFactory
	}
	
	public WebElement getPass()
	{
		return pass;
	}
	
	public WebElement getLoginBtn()
	{
		return loginbtn;
	}
	

}
