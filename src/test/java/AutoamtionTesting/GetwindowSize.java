package AutoamtionTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetwindowSize {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
	    driver.get("https://stage.hellohero.com/login");
	    System.out.println(driver.manage().window().getSize()); 

	    driver.manage().window().maximize();
	    System.out.println(driver.manage().window().getSize()); 
	    
	  
	}

}
