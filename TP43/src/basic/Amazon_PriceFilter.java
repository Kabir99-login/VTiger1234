package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_PriceFilter {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
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
		Thread.sleep(5000);
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@data-cy='title-recipe']/descendant::h2/span|//span[@class='a-price']/descendant::span[@class='a-price-whole']/.."));
		
		for(int i = 0;i<products.size();i++) {
			if(i==0 || i%2==0)
				System.out.print("Name:"+products.get(i).getText()+" ");
			else
				System.out.print("Price: "+products.get(i).getText());
			System.out.println();
		}

		Thread.sleep(5000);
		driver.quit();
	}
}