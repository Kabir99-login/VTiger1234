package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	public static void main(String[] args)throws Exception  {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		/*driver.get("https://demoapps.qspiders.com/ui/fileUpload?sublist=0");
		Thread.sleep(3000);
		
		driver.findElement(By.id("resume")).sendKeys("C:\\Users\\User\\Desktop\\AdvSel_Selenium_API\\Basic Selenium\\MultipleWindows.html");*/
		
		driver.get("https://demoapps.qspiders.com/ui/fileUpload/multiple?sublist=3");
		Thread.sleep(3000);
		String f1 = "C:\\Users\\User\\Desktop\\AdvSel_Selenium_API\\Basic Selenium\\MultipleWindows.html";
		String f2 = "C:\\Users\\User\\Desktop\\AdvSel_Selenium_API\\Basic Selenium\\Locator_Info.txt";
		
		String file=f1+"\n"+f2;
		driver.findElement(By.id("fileInput")).sendKeys(file);
		
		
		Thread.sleep(5000);
		driver.quit();
		
	}
}
