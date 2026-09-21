package ddt;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertyFile {
	public static void main(String[] args) throws Exception {
		//1. Open the file in read mode
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		
		//2. Create object of Properties class to read data based on key
		Properties p = new Properties();
		
		p.load(fis);
		
		System.out.println("URL:"+ p.getProperty("url"));
		System.out.println("Username:"+p.getProperty("userName"));
		System.out.println("Password:"+p.getProperty("password"));
		
		WebDriver driver;
		
		if(p.getProperty("browser").equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(p.getProperty("browser").equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(p.getProperty("browser").equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(p.getProperty("url"));
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(p.getProperty("userName"));
		Thread.sleep(3000);
		
		driver.findElement(By.id("inputPassword")).clear();
		driver.findElement(By.id("inputPassword")).sendKeys(p.getProperty("password"));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
