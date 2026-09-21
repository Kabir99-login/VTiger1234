package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class Project_Db_Validation {
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		FileInputStream fis;
		FileOutputStream fos;
		//1. Login
		//1.1 read data from property file
		fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String browser=p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("userName");
		String pwd = p.getProperty("password");
		
		//1.2 launch browser
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//1.3 naviagting to app
		driver.get(url);
		
		//1.4 login
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(un);
		
		driver.findElement(By.id("inputPassword")).clear();
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(3000);
		
		//2. create project
		//2.1 go to project feature
		driver.findElement(By.linkText("Projects")).click();
		
		//2.2 click on create project
		driver.findElement(By.xpath("//button[contains(.,'Create Project')]")).click();
		
		//2.3 Reading required data to create project from excel
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		//2.3.1 random number generating for new project name
		Random r = new Random();
		int num = r.nextInt();
		
		String pName=wb.getSheet("Project").getRow(2).getCell(0).toString()+num;
		String pManager=wb.getSheet("Project").getRow(2).getCell(1).toString();
		String pStatus=wb.getSheet("Project").getRow(2).getCell(2).toString();
		
		
		//2.4 creating project
		driver.findElement(By.name("projectName")).clear();
		driver.findElement(By.name("projectName")).sendKeys(pName);
		
		driver.findElement(By.name("createdBy")).clear();
		driver.findElement(By.name("createdBy")).sendKeys(pManager);
		
		Select sel = new Select(driver.findElement(By.xpath("//label[text()='Project Status* ']/following-sibling::select[@name='status']")));
		sel.selectByVisibleText(pStatus);
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Thread.sleep(3000);
		
		//2.5 getting project id
		String projectID=driver.findElement(By.xpath("//td[text()='"+pName+"']/preceding-sibling::td")).getText();
		wb.getSheet("Project").getRow(2).createCell(3).setCellValue(projectID);
		wb.getSheet("Project").getRow(2).getCell(0).setCellValue(pName);
		
		//2.6 writing it in sheet
		fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		
		wb.close();
		
		//3. DB validation
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		
		Statement state = con.createStatement();
		
		boolean result = state.execute("select * from project where project_id='"+projectID+"';");
		if(result == true)
			System.out.println("Project created ☺️☺️");
		else
			System.out.println("Project didn't got created🫣🫣");
		
		
		Thread.sleep(5000);
		driver.quit();

	}
}
