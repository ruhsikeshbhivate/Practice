package AutoamtionTesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandles {

	public static void main(String[]args)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("First Tab: "+title);

		//switch selenium focus to the new window...
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com/");
		String title2 = driver.getTitle();
		System.out.println("Second Tab: "+title2);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>();
		handles.addAll(windowHandles);
		
		driver.switchTo().window(handles.get(0));
		String title3 = driver.getTitle();
		System.out.println("First Page: "+title3);
		
		driver.switchTo().window(handles.get(1));
	}
}
