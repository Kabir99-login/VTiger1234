package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://demowebshop.tricentis.com/");
		
		// toLeftOf
		driver.findElement(
				RelativeLocator.with(By.xpath("//ul[@class='top-menu']/descendant::a[contains(text(),'Computers')]"))
						.toLeftOf(By.xpath("//ul[@class='top-menu']/descendant::a[contains(text(),'Electronics')]")))
				.click();
		Thread.sleep(3000);

		// toRightOf
		driver.findElement(
				RelativeLocator.with(By.xpath("//ul[@class='top-menu']/descendant::a[contains(text(),'Electronics')]"))
						.toRightOf(By.xpath("//ul[@class='top-menu']/descendant::a[contains(text(),'Computers')]")))
				.click();
		Thread.sleep(3000);

		// near
		driver.findElement(RelativeLocator.with(By.linkText("Register")).near(By.linkText("Log in"))).click();
		Thread.sleep(3000);

		// above
		driver.findElement(
				RelativeLocator.with(By.linkText("Log in")).above(By.xpath("//input[@value='Search store']"))).click();
		Thread.sleep(3000);
		
		
		// below
		driver.findElement(
				RelativeLocator.with(By.xpath("//ul[@class='top-menu']/descendant::a[contains(text(),'Gift Cards')]"))
						.below(By.xpath("//form[@action='/search']")))
				.click();
		Thread.sleep(5000);
			
		

		driver.quit();
	}
}
