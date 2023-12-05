package AutoamtionTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OtsPortalWindowHandles {

	@Test(invocationCount = 60)
	public void ots() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("http://edubuddy-admin-portal.s3-website-us-east-1.amazonaws.com/");
		WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
		username.sendKeys("anu00");
		
		WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		password.sendKeys("anu00@123");
		
		WebElement signIn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		signIn.click();
		
		driver.close();
		driver.quit();
		
	}

       
}
