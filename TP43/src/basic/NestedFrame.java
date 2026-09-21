package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/frames/nested?sublist=1");
		Thread.sleep(3000);
		
		WebDriver d =driver.switchTo().frame(0);
		d.switchTo().frame(0);
		d.findElement(By.id("email")).clear();
		d.findElement(By.id("email")).sendKeys("sef");
		
		driver = d.switchTo().parentFrame();
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'.com')]")).getText());
		
		Thread.sleep(5000);
		driver.quit();
	}
}
