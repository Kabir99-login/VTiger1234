package basic;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
	public static void main(String[] args) {
		//Launching browser
		WebDriver driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		//1. get method
		driver.get("https://www.myntra.com/");
		
		//2. getTitle
		System.out.println("Title: "+ driver.getTitle());
		
		//3. getCurrentUrl
		System.out.println("Url: "+ driver.getCurrentUrl());
		
		//4. getPageSource
		System.out.println("Page Source:"+ driver.getPageSource());
		
		//5. getWindowHandle
		String parent = driver.getWindowHandle();
		System.out.println("Window id: "+driver.getWindowHandle());
		
		//6. getWindoHandles
		//Set<String> windowss = driver.getWindowHandles();
		//System.out.println("Window id size:"+windowss.size());
		
		//12. findElement
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.linkText("Wall Art")).click();
		driver.findElement(By.xpath("//a[contains(@href,'wall-art')]")).click();
		
		Set<String>windowss = driver.getWindowHandles();
		System.out.println("Window id size:"+windowss.size());
		System.out.println("Window IDs: "+driver.getWindowHandles());
		
		//7. close
		/*driver.close();
		System.out.println("D:"+ driver);*/
		
		//8. quit
		/*driver.quit();
		System.out.println("D:"+ driver);*/
		
		//9. manage
		driver.manage().window().maximize();
		
		//10. switchTo()
		for(String w: windowss) {
//			if(!w.equals(parent))
//				driver.switchTo().window(w);
			 driver.switchTo().window(w);
			if(driver.getTitle().contains("Studio Blue"))
				break;
//				
		}
		driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();
		
		//11. navigate
		driver.navigate().to("https://www.flipkart.com/");
		driver.navigate().back();
		
		System.out.println(driver.findElement(By.xpath("//a[ @data-type=\"navElements\"]")).getText());
		
		//12. findElements
		List<WebElement> eles = driver.findElements(By.xpath("//a[ @data-type='navElements']"));
		for(WebElement ele:eles) {
			System.out.println(ele.getText());
		}
		
	}
}
