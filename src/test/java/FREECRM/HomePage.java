package FREECRM;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	@BeforeTest
	public void FirstThingFirst() throws IOException
	{
		driver = intializerDriver();

	}
	
	@AfterTest
	public void BrowserDown()
	{
		driver.close();
	}

	/* the below dataprovider for importing data from seperate class
	 ---> @Test(dataProvider="getData", dataProviderClass = GetDataProvider.class) 
	   "" in quotes we put dataprovider method name */
	
	/*the below dataprovider is for importing data from method */
	@Test(dataProvider="getData")
	public void HomePageTestCase(String email, String password) throws IOException {
//		driver = intializerDriver();
		driver.get(prop.getProperty("url"));
/*      There are two ways to access the class
*       one -> inheritance
*       Second -> creating objects of that class and invoke methods */
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(email);
		lp.getPass().sendKeys(password);
		lp.getLoginBtn().click();	
	}
	
	// Data Parameterization with dataprovider testng annotation
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2]; // 2 rows and 2 cols
		// give the actual size while passing to array
		// counting starts from 0 -> [1]-row [1]-cols
		
		// first row
		data[0][0] = "firstuser@test.com"; // but index will be starts from 0
		data[0][1] = "PasswordUser1";
		
		//Second row
		data[1][0] = "seconduser@test.com";
		data[1][1] = "PasswordUser2";
		
		return data;
	}

}
