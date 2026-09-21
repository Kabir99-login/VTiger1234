package basic;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitClass {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		FluentWait fw = new FluentWait(Duration.ofSeconds(15));
		//fw.withTimeout(Duration.ofSeconds(15));
		WebElement val = (WebElement) fw.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				 driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).getText().contains("Login was unsuccessful. Please correct the errors and try again.");
				 return  driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
			}
		});
		
		System.out.println(val.getText());
		
		Thread.sleep(5000);
		driver.quit();
		
	}
}
