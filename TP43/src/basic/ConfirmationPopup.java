package basic;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmationPopup {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String product ="Levis Shirt";
		
		driver.get("https://demoapps.qspiders.com/ui/alert?sublist=0");
		
		driver.findElement(By.xpath("//td[text()='"+product+"']/preceding-sibling::td/input")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("deleteButton")).click();
		Thread.sleep(3000);
		
		Alert al = driver.switchTo().alert();
		System.out.println("Alert Messege:"+al.getText());
		al.accept();
		//al.dismiss();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Prompt")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[text()='"+product+"']/preceding-sibling::td/input")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("deleteButton")).click();
		Thread.sleep(3000);
		
		al = driver.switchTo().alert();
		al.sendKeys(product);
		Thread.sleep(3000);
		al.accept();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
