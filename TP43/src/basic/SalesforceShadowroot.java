package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SalesforceShadowroot {
	public static void main(String[] args) throws Exception {
		WebDriver d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		d.get("https://www.salesforce.com/");
		Thread.sleep(5000);

		SearchContext host1 = d.findElement(By.xpath("//hgf-c360nav[@data-lwr-props-id='lwcprops18f0']"))
				.getShadowRoot();

		//host1.findElement(By.cssSelector("hgf-button[class='l1-button'][aria-controls='l1-1']")).click();
		SearchContext host2 = host1.findElement(By.cssSelector("hgf-button[class='l1-button'][aria-controls='l1-2']"))
				.getShadowRoot();
		host2.findElement(By.cssSelector("button")).click();

		// System.out.println(host1.findElement(By.cssSelector("span[class='nav-item-label--l1']")).getText());

		Thread.sleep(5000);
		d.quit();
	}
}
