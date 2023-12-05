package AutoamtionTesting;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CaptureScreenshots {

	public static void main(String[] args) throws IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		TakesScreenshot screen =(TakesScreenshot)driver;
		
		File Source = screen.getScreenshotAs(OutputType.FILE);
		File Desc = new File("C:\\Eclipse Workspace\\MyJavaProject\\SeleniumPractice\\ScreenShots\\FacebookPage.png");
	    FileHandler.copy(Source,Desc);
	    
	}

}
