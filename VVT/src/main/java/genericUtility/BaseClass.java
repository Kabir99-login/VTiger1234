package genericUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseClass {
	public WebDriver driver = null;
	public WebDriverUtility wu = new WebDriverUtility();
	FileUtility fu = new FileUtility();
	
	@BeforeSuite
	public void dbConnection() {
		Reporter.log("Before Suite",true);
		//db connection
	}
	
	@BeforeTest
	public void bt() {
		Reporter.log("Before Test",true);
		//not required
	}
	
	@BeforeClass
	public void navigateTOApp()throws Exception {
		Reporter.log("Before Class",true);
		driver = wu.launchBrowser(fu.getDataFromPropertyFile("browser"));
		driver.get(fu.getDataFromPropertyFile("url"));
	}
	
	@BeforeMethod
	public void login() throws Exception {
		Reporter.log("Before Method",true);
		/*LoginPage lp = new LoginPage(driver);
		lp.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));*/
	}
	
	@AfterMethod
	public void logout() {
		Reporter.log("After Method",true);
		driver.findElement(By.xpath("//div[@title='Logout']")).click();
	}
	
	@AfterClass
	public void closeBrowser() {
		Reporter.log("After Class",true);
		driver.quit();
	}
	
	@AfterTest
	public void at() {
		Reporter.log("After Test",true);
	}
	
	@AfterSuite
	public void closeConnection() {
		Reporter.log("After Suite",true);
		//close db connection
	}
}
