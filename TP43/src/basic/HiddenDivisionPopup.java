package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HiddenDivisionPopup {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/hidden?sublist=0");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[text()='Add Customer']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("customerName")).clear();
		driver.findElement(By.id("customerName")).sendKeys("customerName");
		Thread.sleep(2000);
		
		driver.findElement(By.id("customerEmail")).clear();
		driver.findElement(By.id("customerEmail")).sendKeys("customerEmail@gmail.com");
		Thread.sleep(2000);
		
		Select sel = new Select(driver.findElement(By.id("prod")));
		sel.selectByIndex(1);
		Thread.sleep(2000);
		
		driver.findElement(By.id("message")).clear();
		driver.findElement(By.id("message")).sendKeys("message");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
	}
}
