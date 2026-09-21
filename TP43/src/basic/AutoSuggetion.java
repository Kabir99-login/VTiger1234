package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggetion {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oppo");
		Thread.sleep(3000);
		
		List<WebElement> autoSuggestion =driver.findElements(By.xpath("//div[@class='left-pane-results-container']"
				+ "/descendant::div[@aria-label]"));
		for(WebElement auto : autoSuggestion) {
			System.out.println(auto.getText());
		}
		
		Thread.sleep(5000);
		driver.quit();
	}
}
