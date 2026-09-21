package basic;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindows {
	public static void main(String[] args) throws Exception {
		ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        // 1 = Allow notifications
        prefs.put(
            "profile.default_content_setting_values.notifications",
            1
        );
		
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		String exp1 = "https://www.amazon.in/";
		String exp2 = "flipkart";
		String exp3 = "Buy Beauty";

		driver.get("file:///C:/Users/User/Desktop/AdvSel_Selenium_API/Basic%20Selenium/MultipleWindows.html#");

		driver.findElement(By.xpath("//a[contains(text(),'E-Commerce Websites')]")).click();

		System.out.println("Current windowID info:" + driver.getWindowHandle() + " Title:" + driver.getTitle());

		Thread.sleep(2000);

		// 1. amazon
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {
			driver.switchTo().window(windowId);
			if (driver.getCurrentUrl().equals(exp1))
				break;
		}

		System.out.println("**************************************************");
		System.out.println("Current windowID info:" + driver.getWindowHandle() + " Title:" + driver.getTitle());

		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("lamp", Keys.ENTER);
		Thread.sleep(2000);

		// 2. flipkart
		for (String windowId : windowIds) {
			driver.switchTo().window(windowId);
			if (driver.getCurrentUrl().contains(exp2))
				break;
		}

		System.out.println("**************************************************");
		System.out.println("Current windowID info:" + driver.getWindowHandle() + " Title:" + driver.getTitle());
		driver.findElement(By.xpath("//span[@class='b3wTlE']")).click();
		Thread.sleep(2000);
		
		//3. purplle
		for (String windowId : windowIds) {
			driver.switchTo().window(windowId);
			if (driver.getTitle().contains(exp3))
				break;
		}
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("app-top-banner"))));
//		
		System.out.println("**************************************************");
		System.out.println("Current windowID info:" + driver.getWindowHandle() + " Title:" + driver.getTitle());;
		
//		WebElement search = driver.findElement(By.xpath("//input[@type='search' ]"));
//		search.click();
//		search.clear();
//		search.sendKeys("facewash");
//		driver.findElement(By.xpath("//i")).click();
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.partialLinkText("SHOP CATEGORIES"))).
		moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Makeup')]"))).perform();
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Eyeliner')]"))).click().build().perform();
		
		
		
		
		

		Thread.sleep(5000);
		driver.quit();
	}
}
