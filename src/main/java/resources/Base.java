package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver intializerDriver() throws IOException {
		prop = new Properties();
		String CurrentDirectory = System.getProperty("user.dir");
		FileInputStream file = new FileInputStream(CurrentDirectory+"\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		String browserName = prop.getProperty("browser");
		
/*Note:
*    use "equals" or "equalsIgnoreCase" methods instead of "==" operator in if statement
 
      Difference between "==" operator and "equals"/"equalsIgnoreCase"
      
* 	  "==" -> this is a reference comparison operator i.e both objects point to the same memory location
*    "equals" or "equalsIgnoreCase" -> evaluates to the comparison of values in the objects/properties
*    (pulling values from other objects/resources)
*/
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equals("firefoc"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

}
