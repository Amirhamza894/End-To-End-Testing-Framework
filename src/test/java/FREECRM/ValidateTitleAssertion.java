package FREECRM;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTitleAssertion extends base {

	@BeforeTest
	public void FirstThingFirst() throws IOException
	{
		driver = intializerDriver();
		driver.get(prop.getProperty("url"));
/*      There are two ways to access the class
*       one -> inheritance
*       Second -> creating objects of that class and invoke methods
*/
	}
	
	@AfterTest
	public void BrowserDown()
	{
		driver.close();
	}

	@Test
	public void HomePageTest() throws IOException {

		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.btntxt().getText(), "VIEW ALL COURSES");
		Assert.assertTrue(l.navbaelement().isDisplayed());
			
	}

}
