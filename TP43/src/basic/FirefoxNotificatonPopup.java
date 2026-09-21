package basic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxNotificatonPopup {
	public static void main(String[] args) throws Exception {
//		FirefoxOptions fop = new FirefoxOptions();
//		fop.addPreference("dom.webnotifications.enabled",false);
//		fop.addPreference("geo.enabled", false);
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://in.bookmyshow.com/");
		
		Thread.sleep(15000);
		driver.quit();
	}
}
