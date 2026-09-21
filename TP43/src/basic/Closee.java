package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Closee {
	public static void main(String[] args) throws Exception {
		// Launching browser
		WebDriver driver = new ChromeDriver();
		// driver = new FirefoxDriver();

		// 1. get method
		driver.get("https://www.myntra.com/");

		// 2. getTitle
		System.out.println("Title: " + driver.getTitle());

		// 3. getCurrentUrl
		System.out.println("Url: " + driver.getCurrentUrl());
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com/");
		
		System.out.println(driver.getWindowHandles().size());
		System.out.println(driver);
	}
}
