package basic;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownload {
	public static void main(String[] args) throws Exception {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("profile.default_content_settings.popups", 0);
		map.put("download.default_directory", "./files");
		map.put("download.prompt_for_download", false);
		
		options.setExperimentalOption("prefs", map);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demoapps.qspiders.com/ui/download?sublist=0");
		Thread.sleep(3000);
		driver.findElement(By.id("writeArea")).clear();
		driver.findElement(By.id("writeArea")).sendKeys("ADSFSFS");
		Thread.sleep(3000);
		driver.findElement(By.id("downloadButton")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
