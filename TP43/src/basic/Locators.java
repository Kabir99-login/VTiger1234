package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	public static void main(String[] args) throws Exception {
		//1. Launching browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//2. Navigating to application
		driver.get("https://demowebshop.tricentis.com");
		
		//3. Registration Page
		driver.findElement(By.linkText("Register")).click();
		//driver.findElement(By.className("ico-register")).click();
		Thread.sleep(2000);
		
		//4. Selecting gender
		//driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.cssSelector("#gender-male")).click();
		driver.findElement(By.cssSelector("input[id='gender-male']"));
		Thread.sleep(2000);
		
		//5. Entering 1st name
		driver.findElement(By.name("FirstName")).clear();
		driver.findElement(By.id("FirstName")).sendKeys("Ritesh");
		Thread.sleep(2000);
		
		//6. Entering last name
		driver.findElement(By.xpath("/html/body/div[@class='master-wrapper-page']/div[@class='master-wrapper-content']/div[@class='master-wrapper-main']/div[@class='center-2']/form/div/div[@class='page-body']/div[@class='fieldset'][1]/div[@class='form-fields']/div[3]/input")).clear();
		driver.findElement(By.xpath("/html/body/div[@class='master-wrapper-page']/div[@class='master-wrapper-content']/div[@class='master-wrapper-main']/div[@class='center-2']/form/div/div[@class='page-body']/div[@class='fieldset'][1]/div[@class='form-fields']/div[3]/input")).sendKeys("Deshmukh");
		Thread.sleep(2000);
		
		//7. Entering email
		driver.findElement(By.xpath("//input[@data-val-required='Email is required.']")).clear();
		driver.findElement(By.xpath("//input[@data-val-required='Email is required.']")).sendKeys("riteshD72@gmail.com");
		Thread.sleep(2000);
		
		//8. Entering password
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("RiteshD123");
		Thread.sleep(2000);
		
		//9, Entering confirm password
		driver.findElement(By.name("ConfirmPassword")).clear();
		driver.findElement(By.id("ConfirmPassword")).sendKeys("RiteshD123");
		Thread.sleep(2000);
		
		//10. Clicking on register button
		driver.findElement(By.id("register-button")).click();
		Thread.sleep(2000);
		
		//11. Clicking on category
		driver.findElement(By.partialLinkText("BOOKS")).click();
		Thread.sleep(2000);
		
		//12. Selecting a product
		driver.findElement(By.partialLinkText("Computing and Internet")).click();
		Thread.sleep(2000);
		
		//13. Adding product to cart
		driver.findElement(By.id("add-to-cart-button-13")).click();
		Thread.sleep(2000);
		
		//14. Moving to cart page
		driver.findElement(By.cssSelector("li[id='topcartlink']>a[href='/cart']")).click();
		Thread.sleep(4000);
		
		//13. Closing browser
		driver.quit();
	}
}
