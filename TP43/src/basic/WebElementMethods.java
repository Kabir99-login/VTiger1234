package basic;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		
		//1. click()
		driver.findElement(By.linkText("Log in")).click();
		
		//2. clear()
		driver.findElement(By.id("Email")).clear();
		
		//3. sendKeys()
		driver.findElement(By.id("Email")).sendKeys("sonawaletanuja55@gmail.com",Keys.CONTROL,"a",Keys.CONTROL,"c",Keys.TAB,Keys.CONTROL,"v");
		
		//4. isSelected()
		driver.findElement(By.id("RememberMe")).click();
		System.out.println("isSelcted:"+driver.findElement(By.id("RememberMe")).isSelected());
		
		//5. submit()
		driver.findElement(By.xpath("//input[@value='Log in']")).submit();
		
		//6. getDomAttribute()
		driver.findElement(By.id("small-searchterms")).clear();
		driver.findElement(By.id("small-searchterms")).sendKeys("book");
		
		System.out.println("getDomAttribute:"+driver.findElement(By.id("small-searchterms")).getDomAttribute("value"));
		
		//7. getAttribute()
		System.out.println("getAttribute:"+driver.findElement(By.id("small-searchterms")).getAttribute("value"));
		
		//8. getSize()
		Dimension d = driver.findElement(By.id("small-searchterms")).getSize();
		System.out.println("Height:"+d.getHeight()+" Weidth:"+d.getWidth()+" Dimension:"+d);
		
		//9. getLocation()
		Point p = driver.findElement(By.id("small-searchterms")).getLocation();
		System.out.println("x:"+p.x+" y:"+p.getY()+" Point:"+p);
		
		//10. getRect()
		Rectangle r = driver.findElement(By.id("small-searchterms")).getRect();
		System.out.println("getRect height:"+r.height+" getRect width:"+r.width+" getRect x:"+r.x+" getRect y:"+r.y);
		
		//11. isEnabled()
		System.out.println("isEnabled:"+driver.findElement(By.id("small-searchterms")).isEnabled());
		
		//12. isDisplayed()
		System.out.println("isDisplayed:"+driver.findElement(By.id("Email")).isDisplayed());
		
		//13. getScreenshotAs()
		File f =driver.findElement(By.id("Email")).getScreenshotAs(OutputType.FILE);
		File f1 = new File("./ss/Img2.png");
		FileHandler.copy(f, f1);
		
		// screenshot of webpage
		//1. typecasting of driver to TakesScreenshot type 
		TakesScreenshot ts = (TakesScreenshot)driver;
		//2. taking ss of webpage
		File temp = ts.getScreenshotAs(OutputType.FILE);
		//3. create per storage
		File per = new File("./ss/Page1.png");
		//4. store the screenshot in per location
		FileHandler.copy(temp, per);
		
		Thread.sleep(5000);
		driver.quit();
	}
}
