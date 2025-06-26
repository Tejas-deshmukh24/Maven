package Advance_Report;

/*import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLink_Test {
	
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new  ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.epfindia.gov.in/site_en/index.php");
		
//		List<WebElement>allLinks=driver.findElement(By.xpath("//a"));
		
//		List<WebElement> allLinks = driver.findElement(By.tagName("a"));
		

		List<WebElement> allLinks = driver.findElement(By.tagName("a")); 
		
		System.out.println(allLinks.size());
		
		for(WebElement eachLink : allLinks) {
			String eachLink = Link.getAttribute("href");
			try {
				URL url = new URL(Link);
				HttpURLConnection httpconn = (HttpURLConnection)url.openConnection();
				int StatusCode = httpconn.getResponseCode();
				if(StatusCode>400)
				{
					System.out.println(Link+"==>"+StatusCode);
				}
			}catch(Exception e) {
				System.out.println("No Broken Link");
				
				}			
			}
		   driver.quit();
		}
			
	}*/

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLink_Test {
//private static final HttpURLConnection HttpURLConnection = null;

@Test
public void checkBrokenLinks() {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	driver.get("https://www.epfindia.gov.in/site_en/index.php");
	  List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	System.out.println(allLinks.size());
	for(WebElement link:allLinks)
	{
		String eachLink=link.getAttribute("href");
		try {
			URL url =new URL(eachLink);
			HttpURLConnection httpconn=(HttpURLConnection)url.openConnection();
			int statusCode = httpconn.getResponseCode();
			if (statusCode>=400) {
				System.out.println(eachLink+"==>>"+statusCode);
			}}
		catch (Exception e) {
			
		}
			}
	   driver.quit();
		}
	
}

	