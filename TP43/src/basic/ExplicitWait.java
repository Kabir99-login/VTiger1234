package basic;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		//WebElement ele = driver.findElement(By.linkText("Register"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("New products"))));
		wait.ignoring(NoSuchElementException.class);
		
		//driver.findElement(By.linkText("Log in")).click();
		
		driver.quit();
	}
}
