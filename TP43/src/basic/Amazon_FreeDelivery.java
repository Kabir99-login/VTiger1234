package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Amazon_FreeDelivery {
	public static void main(String[] args) throws Exception {

		// 1. Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(3000);

		// 2. Navigate to app
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);

		// 3. Clearing search textfield
		driver.findElement(By.xpath("//div[@class='nav-search-field ']/input[@id='twotabsearchtextbox']")).clear();
		Thread.sleep(3000);

		// 4. Passing data to be searched
		driver.findElement(By.xpath("//div[@class='nav-search-field ']/input[@id='twotabsearchtextbox']"))
				.sendKeys("Headphones");
		Thread.sleep(3000);

		// 5. Clicking on search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);

		// 6. to hold all product name element
		List<WebElement> productNames;
		
		  int lastPage =
		  Integer.parseInt(driver.findElement(RelativeLocator.with(By.xpath(
		  "//div[@aria-label='pagination']/descendant::span[@class='s-pagination-item s-pagination-disabled']"
		  )) .toLeftOf(By.xpath("//a[text()='Next']"))).getText());
		 

		 for (int i = 1; i <= lastPage; i++) {

		// 7. locating products
		productNames = driver.findElements(By.xpath(
				"//div[text()='FREE delivery ']/ancestor::div[@data-cy='delivery-recipe']/preceding-sibling::div[@data-cy='title-recipe']/descendant::h2"));

		// 8. traversing so that we can print product name
		for (WebElement ele : productNames) {
			System.out.println("Product: " + ele.getText());
		}
		 driver.findElement(By.linkText("Next")).click();
		 System.out.println("****************************************************************************");
		 }

		// 9. closing browser
		Thread.sleep(4000);
		driver.quit();
	}
}
