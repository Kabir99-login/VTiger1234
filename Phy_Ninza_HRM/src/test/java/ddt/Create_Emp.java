package ddt;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericUtility.ExcelUility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;

public class Create_Emp {

	public static void main(String[] args) throws Exception {
		WebDriver driver = null;

		PropertyUtility pu = new PropertyUtility();

		String browser = pu.readDataFromPropertFile("browser");
		String url = pu.readDataFromPropertFile("url");
		String un = pu.readDataFromPropertFile("userName");
		String pwd = pu.readDataFromPropertFile("password");

		WebdriverUtility wu = new WebdriverUtility();
		driver = wu.launchBrowser(browser);

		wu.maximizeBrowser(driver);
		wu.implicitWaitMethod(driver);
		driver.get(url);

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(un);

		driver.findElement(By.id("inputPassword")).clear();
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);

		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		driver.findElement(By.linkText("Employees")).click();

		driver.findElement(By.xpath("//button[contains(.,'Add New Employee')]")).click();

		Random r = new Random();
		int num = r.nextInt();

		ExcelUility eu = new ExcelUility();
		String name = eu.readDataFromExcel("Employee", 2, 0) + num;
		String email = eu.readDataFromExcel("Employee", 2, 1);
		String phno = eu.formatedDataFromExcel("Employee", 2, 2);

		String user = eu.readDataFromExcel("Employee", 2, 1) + num;
		String desig = eu.readDataFromExcel("Employee", 2, 1);
		String exp = eu.readDataFromExcel("Employee", 2, 1);
		String project = eu.readDataFromExcel("Employee", 2, 1);

		driver.findElement(By.xpath("//label[text()='Name*']/following-sibling::input[@type='text']")).clear();
		driver.findElement(By.xpath("//label[text()='Name*']/following-sibling::input[@type='text']")).sendKeys(name);

		driver.findElement(By.xpath("//label[text()='Email*']/following-sibling::input[@type='email']")).clear();
		driver.findElement(By.xpath("//label[text()='Email*']/following-sibling::input[@type='email']"))
				.sendKeys(email);

		driver.findElement(By.xpath("//label[text()='Phone*']/following-sibling::input[@type='text']")).clear();
		driver.findElement(By.xpath("//label[text()='Phone*']/following-sibling::input[@type='text']")).sendKeys(phno);

		driver.findElement(By.xpath("//label[text()='Username*']/following-sibling::input[@type='text']")).clear();
		driver.findElement(By.xpath("//label[text()='Username*']/following-sibling::input[@type='text']"))
				.sendKeys(user);

		driver.findElement(By.xpath("//label[text()='Designation*']/following-sibling::input[@type='text']")).clear();
		driver.findElement(By.xpath("//label[text()='Designation*']/following-sibling::input[@type='text']"))
				.sendKeys(desig);

		driver.findElement(By.xpath("//label[text()='Experience*']/following-sibling::input[@type='text']")).clear();
		driver.findElement(By.xpath("//label[text()='Experience*']/following-sibling::input[@type='text']"))
				.sendKeys(exp);

		WebElement projectDD = driver.findElement(By.name("project"));
		wu.selectFromDD(projectDD, project);

		driver.findElement(By.xpath("//input[@value='Add']")).click();

		Thread.sleep(5000);
		driver.quit();
	}
}
