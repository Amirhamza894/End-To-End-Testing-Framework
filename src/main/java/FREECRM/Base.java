package FREECRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver;
	public void initializeDriver() throws IOException
	{

		Properties prop = new Properties();
		String currentDirectory = System.getProperty("user.dir");
		System.out.println(currentDirectory);
		FileInputStream fis = new FileInputStream(currentDirectory+"\\src\\main\\java\\FREECRM\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName == "chrome")
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName == "edge")
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browserName == "firefox")
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

	}
}
