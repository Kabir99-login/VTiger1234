package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DefaultFrame {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/frames?sublist=0");
		Thread.sleep(3000);
		
		WebElement f1 = driver.findElement(By.xpath("//iframe"));
		
		driver.switchTo().frame(f1);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("abc");
		
		Thread.sleep(5000);
		driver.quit();
	}
}
