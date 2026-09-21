package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenShadowrootElement {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");

		/*
		 * Approach 1 
		 * //1. locating host1 
		 * SearchContext host1 =driver.findElement(By.xpath("//div[@class='my-3'][1]")).getShadowRoot();
		 * 
		 * //2. locating shadow root element with the help of host
		 * host1.findElement(By.cssSelector("input[placeholder='Enter your username']"))
		 * .clear();
		 * host1.findElement(By.cssSelector("input[placeholder='Enter your username']"))
		 * .sendKeys("asfa"); Thread.sleep(3000);
		 * 
		 * //3. locating host2 
		 * SearchContext host2 =driver.findElement(By.xpath("//div[@class='my-3'][2]")).getShadowRoot();
		 * 
		 * //4. locating shadow root element with the help of host
		 * host2.findElement(By.cssSelector("input[placeholder='Enter your password']"))
		 * .clear();
		 * host2.findElement(By.cssSelector("input[placeholder='Enter your password']"))
		 * .sendKeys("afaf"); Thread.sleep(3000);
		 */

		// 5. click on login button
		Thread.sleep(5000);
		// Approach 2
		/*Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("//h1[text()='Login']")))
				.sendKeys(Keys.TAB, "sdghfhsdg", Keys.TAB, "sjhfjsf").perform();
		driver.findElement(By.xpath("//button[text()='Login']")).click();*/
		
		//Approach 3
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].shadowRoot.querySelector('input[placeholder=\"Enter your username\"]').value='sd'", 
				driver.findElement(By.xpath("//div[@class='my-3'][1]")));
		
		js.executeScript("arguments[0].shadowRoot.querySelector('input[placeholder=\"Enter your password\"]').value='erfsf';", 
				driver.findElement(By.xpath("//div[@class='my-3'][2]")));

		Thread.sleep(5000);
		driver.quit();
	}
}
