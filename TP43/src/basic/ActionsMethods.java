package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;

public class ActionsMethods {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.myntra.com/");
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Women']"))).
		pause(Duration.ofSeconds(2)).
		click(driver.findElement(By.xpath("//a[text()='Kurtas & Suits']"))).perform();
		
		//act.click(driver.findElement(By.linkText("Women"))).perform();
		
		
		WebElement greenColor=driver.findElement(By.xpath("//label[contains(.,'Green')]"));
		
		//act.scrollByAmount(0, 800).perform();
		
		
		act.scrollToElement(greenColor).perform();
		Thread.sleep(4000);
		
		//act.dragAndDropBy(driver.findElement(By.id("rootRailThumbLeft")), 100, 0).perform();
		act.clickAndHold(driver.findElement(By.id("rootRailThumbLeft"))).
		pause(Duration.ofSeconds(1)).moveByOffset(40, 0).pause(1000).
		release().build().perform();
		
		
		
		
		
		
		
		
		
		
		/*ScrollOrigin scroll = WheelInput.ScrollOrigin.fromElement(greenColore);
		act.scrollFromOrigin(scroll, 0,800).perform();*/
		
		Thread.sleep(5000);
		driver.quit();
	}
}
