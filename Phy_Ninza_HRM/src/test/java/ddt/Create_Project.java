package ddt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericUtility.DatabaseUtility;
import genericUtility.ExcelUility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;
import objectRepo.Login_Page;

public class Create_Project {
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		//1. Login
		//1.1 read data from property file
		PropertyUtility p = new PropertyUtility();
		
		String browser =p.readDataFromPropertFile("browser");
		String url = p.readDataFromPropertFile("url");
		String un = p.readDataFromPropertFile("userName");
		String pwd = p.readDataFromPropertFile("password");
		
		//1.2 launch browser
		WebdriverUtility wu = new WebdriverUtility();
		driver = wu.launchBrowser(browser);
		
		wu.maximizeBrowser(driver);
		wu.implicitWaitMethod(driver);
		
		//1.3 naviagting to app
		driver.get(url);
		
		//1.4 login
		Login_Page lp = new Login_Page(driver);
		lp.userLogin(un, pwd);
		
		Thread.sleep(3000);
		
		//2. create project
		//2.1 go to project feature
		driver.findElement(By.linkText("Projects")).click();
		
		//2.2 click on create project
		driver.findElement(By.xpath("//button[contains(.,'Create Project')]")).click();
		
		//2.3 Reading required data to create project from excel
		ExcelUility eu = new ExcelUility();
		//2.3.1 random number generating for new project name
		JavaUtility ju = new JavaUtility();
		
		String pName=eu.readDataFromExcel("Project", 1, 0)+ju.genRandomNumber();
		String pManager=eu.readDataFromExcel("Project", 1, 1);
		String pStatus=eu.readDataFromExcel("Project", 1, 2);
		
		
		//2.4 creating project
		driver.findElement(By.name("projectName")).clear();
		driver.findElement(By.name("projectName")).sendKeys(pName);
		
		driver.findElement(By.name("createdBy")).clear();
		driver.findElement(By.name("createdBy")).sendKeys(pManager);
		
		WebElement ele = driver.findElement(By.xpath("//label[text()='Project Status* ']/following-sibling::select[@name='status']"));
		wu.selectFromDD(ele,pStatus);
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Thread.sleep(3000);
		
		//2.5 getting project id
		String projectID=driver.findElement(By.xpath("//td[text()='"+pName+"']/preceding-sibling::td")).getText();
		
		eu.writeDataInNewCell("Project", 1, 3, projectID);
		eu.writeDataInExestingCell("Project", 1, 0, pName);
		
		//db validation
		DatabaseUtility du = new DatabaseUtility();
		boolean b = du.validateDataEntry("project","project_name",pName,"jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		
		if(b==true)
			System.out.println("Project with "+pName+" got created in frontend n is available in backend");
		else
			System.out.println("Project with "+pName+" didn't got created in frontend n is not available in backend");
		
		Thread.sleep(5000);
		driver.quit();
		
		System.out.println("Date:"+ju.currentDate());
	}
}






