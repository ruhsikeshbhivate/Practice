package AutoamtionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getBrokenLink {

	public static void main(String[] args) {
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		//Maximixe window size....
		driver.manage().window().maximize();
		driver.get("https://stage.hellohero.com/login");

		//login by admin...
		WebElement username = driver.findElement(By.xpath("//input[@id=\"login\"]"));
		username.sendKeys("sagar_admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		password.sendKeys("Sagar@Admin3343");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
		loginButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> LinkList = driver.findElements(By.tagName("a"));
		
		System.out.println("Total link on web page: " + LinkList.size());
		
		int resCode = 200;
		int brokenlinkCount = 0;
		int activelinkcount = 0;
		for(WebElement element: LinkList)
		{
			String url = element.getAttribute("href");
			
			try 
			{
				URL urlLink = new URL(url);
				HttpURLConnection connects = (HttpURLConnection)urlLink.openConnection();
				connects.setRequestMethod("HEAD");
				connects.connect();
				
				resCode = connects.getResponseCode();
				
				if(resCode >= 400)
				{
					System.out.println(url + " broken link...");
					brokenlinkCount++;
				}
				else {
					System.out.println(url);
					activelinkcount++;
				}
			}
			catch (Exception e) 
			{
				
			}
		}
		
		System.out.println("Total broken link on web page: " + brokenlinkCount);
	}
	
}
