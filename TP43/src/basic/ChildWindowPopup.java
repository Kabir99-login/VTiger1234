package basic;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindowPopup {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/browser?sublist=0");
		
		//String parent = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//h2[text()='Watches']/following-sibling::button[text()='view more']")).click();
		Thread.sleep(3000);

		
		Set<String> windows = driver.getWindowHandles();
		for(String w : windows) {
			driver.switchTo().window(w);
			if(driver.getTitle().contains("Watch"))
				break;
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
		Thread.sleep(4000);
		driver.close();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
