package genericUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import objectRepo.LoginPage;

public class BaseClass {
	public WebDriver driver = null;
	public WebDriverUtility wu = new WebDriverUtility();
	FileUtility fu = new FileUtility();
	
	@BeforeSuite
	public void dbConnection() {
		//db connection
	}
	
	@BeforeTest
	public void bt() {
		//not required
	}
	
	@BeforeClass
	public void navigateTOApp()throws Exception {
		driver = wu.launchBrowser(fu.getDataFromPropertyFile("browser"));
		driver.get(fu.getDataFromPropertyFile("url"));
	}
	
	@BeforeMethod
	public void login() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//div[@title='Logout']")).click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterTest
	public void at() {
		
	}
	
	@AfterSuite
	public void closeConnection() {
		//close db connection
	}
}
