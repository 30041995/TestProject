package AutoMateCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationTask {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ROHIT\\Desktop\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.hotwire.com/packages/");
		
		driver.findElement(By.xpath("//span[text()='Car']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement leavingfrom=driver.findElement(By.xpath("//button[@aria-label='Leaving from']"));
		leavingfrom.sendKeys("SFO");

		WebElement sourceto=driver.findElement(By.xpath("//button[@aria-label='Going to']"));
		sourceto.sendKeys("LAX");
		
		
	}

}
