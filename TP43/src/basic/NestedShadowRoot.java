package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NestedShadowRoot {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/shadow/nested?sublist=2");
		
		//1. Open to Close
		//1.1 locate host which is outer shadow root element(open)
		SearchContext host = driver.findElement(By.xpath("//div[@class='shadowOuter']")).getShadowRoot();
		Thread.sleep(3000);
		
		//1.2 locating inner shadow root element(close)
		Actions act = new Actions(driver);
		act.sendKeys(host.findElement(By.cssSelector("label[for='email']")),Keys.TAB,"sdf").perform();
		Thread.sleep(3000);
		
		//2. Close to Open
		//2.1 Locate nearest and then the shadow root element
		act.sendKeys(host.findElement(By.cssSelector("label[for='email']")),Keys.TAB,Keys.TAB,"sdf").perform();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
