package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		/*driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.xpath("//ul[@class='top-menu']/descendant::a[contains(text(),'Books')]")).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//select[@id='products-orderby']/option[text()='Price: High to Low']")).click();
		
		Select sortBy = new Select(driver.findElement(By.id("products-orderby")));
		
		// 1.getOptions()
		List<WebElement> sortByEles = sortBy.getOptions();
		for(WebElement sortByEle:sortByEles) {
			System.out.println(sortByEle.getText());
		}
		
		System.out.println("*******************************************************");
		// 2.getWarappedElement()
		WebElement eles = sortBy.getWrappedElement();
		System.out.println(eles.getText());
		
		System.out.println("*******************************************************");
		// 3.isMultiple()
		System.out.println(sortBy.isMultiple());
		
		System.out.println("*******************************************************");
		// 4.selectByIndex
		sortBy.selectByIndex(1);
		
		System.out.println("*******************************************************");
		// 5.selectByValue
		sortBy = new Select(driver.findElement(By.id("products-orderby")));
		sortBy.selectByValue("https://demowebshop.tricentis.com/books?orderby=10");
		
		System.out.println("*******************************************************");
		// 6.selectByVisibleText()
		sortBy = new Select(driver.findElement(By.id("products-orderby")));
		sortBy.selectByVisibleText("Position");
		
		System.out.println("*******************************************************");
		// 7.getFirstSelectedOption()
		sortBy = new Select(driver.findElement(By.id("products-orderby")));
		WebElement firstSelect = sortBy.getFirstSelectedOption();
		System.out.println("FS:"+firstSelect.getText());*/
		
		/*driver.get("https://demoapps.qspiders.com/ui/dropdown/multiSelect?sublist=1");
		Select sel = new Select(driver.findElement(By.id("select-multiple-native")));
		
		System.out.println("is Multiple:"+sel.isMultiple());
		
		sel.selectByIndex(5);
		sel.selectByVisibleText("Mens Cotton Jacket...");
		sel.selectByValue("SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s");
		sel.selectByContainsVisibleText(" Power 256GB ...");
		
		List<WebElement> selected = sel.getAllSelectedOptions();
		for(WebElement select:selected) {
			System.out.println("Product name:"+select.getText());
		}
		Thread.sleep(3000);
		
		System.out.println("*******************************************************");
		sel.deselectByVisibleText("Mens Cotton Jacket...");
		
		selected = sel.getAllSelectedOptions();
		for(WebElement select:selected) {
			System.out.println("Product name:"+select.getText());
		}
		
		sel.deselectAll();*/
		
		driver.get("https://demoapps.qspiders.com/ui/dropdown/disabled?sublist=3");
		List<WebElement> eles = driver.findElements(By.xpath("//select[@id='SelectCountry']/option"));
		for(WebElement ele:eles) {
			System.out.println("Country:"+ele.getText()+" Interactable:"+ele.isEnabled());
			if(ele.getText().equalsIgnoreCase("India")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", ele);
				
			}
		}
		
		
		Thread.sleep(5000);
		driver.quit();
		
	}
}
