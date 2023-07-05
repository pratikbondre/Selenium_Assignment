package amazon;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import helper.BaseClass;

public class NewSearch extends BaseClass {
	
	
  @Test(description = "Product Search")
  public void Watch() throws Exception {
	  Properties prop = new Properties();
	  prop.load(new FileInputStream("src\\test\\resources\\Property_Demo\\Amazon_Search_Property"));
	  
	  System.setProperty(prop.getProperty("ckey"), prop.getProperty("cvalue"));
	  
	  wd.get(prop.getProperty("url"));
	  wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  wd.get(prop.getProperty("url"));
	  wd.findElement(By.id(prop.getProperty("Searchbox"))).sendKeys(prop.getProperty("Product"));
	  wd.findElement(By.xpath(prop.getProperty("submit"))).sendKeys(Keys.ENTER);
	  wd.findElement(By.xpath(prop.getProperty("Display"))).click();
	  wd.findElement(By.xpath(prop.getProperty("Brands_Material"))).click();
	  wd.findElement(By.xpath(prop.getProperty("Brand"))).click();
	  wd.findElement(By.xpath(prop.getProperty("Discount"))).click();
	  wd.findElement(By.id(prop.getProperty("Searchbox"))).sendKeys(prop.getProperty("discounts"));
	  wd.findElement(By.xpath(prop.getProperty("submit"))).sendKeys(Keys.ENTER);
	  
	  
  }
  public WebElement getLocator(String element) {
	  WebElement e = null;
	  String locvalue  =element.split(":=")[0];
	  String locType   =element.split(":=")[1];
	  /*	split() splits a String into multiple
	   * 		Strings given delimiter that separates them
	   * 		Returned Object is an Array which contains split String
	   */
	  if(locType.equalsIgnoreCase("id"))
		  e=wd.findElement(By.id(locvalue));
	  else if(locType.equalsIgnoreCase("name"))
		  e=wd.findElement(By.name(locvalue));
	  else if(locType.equalsIgnoreCase("xpath"))
		  e=wd.findElement(By.xpath(locvalue));
	  else if(locType.equalsIgnoreCase("cssSelector"))
		  e=wd.findElement(By.cssSelector(locvalue));
	  return e;
		  
		  
	  }
}
