package helper;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseClass {
	
	public WebDriver wd;
	public Properties prop;
	@BeforeTest
	public void launchBrowser() throws Exception  
	{
		prop = new Properties();
		prop.load(new FileInputStream("src\\test\\resources\\Property_Demo\\Amazon_Search_Property"));
		prop.getProperty("browser");
		
		System.setProperty(prop.getProperty("ckey"), prop.getProperty("cvalue"));
		
		wd = new ChromeDriver();
	}
 /* @AfterTest
  public void closeBrowser() {
	  wd.quit();
  }
*/}
