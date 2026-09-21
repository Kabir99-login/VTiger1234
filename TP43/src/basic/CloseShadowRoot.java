package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CloseShadowRoot {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/shadow/closed?sublist=1");
		
		//1. locate nearest element
		WebElement ele = driver.findElement(By.xpath("//h1[text()='Login']"));
		Thread.sleep(3000);
		
		//2. entering username
		Actions act = new Actions(driver);
		act.click(ele).sendKeys(Keys.TAB,"adasd",Keys.TAB,"dfaf",Keys.TAB,Keys.ENTER).perform();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
