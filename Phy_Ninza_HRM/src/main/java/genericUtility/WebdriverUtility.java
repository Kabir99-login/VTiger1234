package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility {
	public WebDriver driver;
	
	public WebDriver launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();
		return driver;
	}
	
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitWaitMethod(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void handlingWindows(WebDriver driver,String targetTitle) {
		Set<String> windowIds = driver.getWindowHandles();
		for(String windowId:windowIds) {
			driver.switchTo().window(windowId);
			if(driver.getTitle().contains(targetTitle))
				break;
		}
	}
	
	public void selectFromDD(WebElement ele,String visibleText) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(visibleText);
	}
	
	public void selectFromDD(String value,WebElement ele) {
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}
	
	public void selectFromDD(int index,WebElement ele) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
	
	public void moveToElementAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
}
