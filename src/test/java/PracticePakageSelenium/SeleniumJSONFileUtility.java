package PracticePakageSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import PracticeGenericUtilityFile.JsonUtilityFlipkart;

public class SeleniumJSONFileUtility {

	public static void main(String[] args) throws Throwable {
		
		JsonUtilityFlipkart flip=new JsonUtilityFlipkart();
		
		String browser=flip.getDatafromJson("browser");
		String url=flip.getDatafromJson("url");
		String search=flip.getDatafromJson("search");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.className("Pke_EE")).sendKeys(search);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.close();

		
		
		
		

	}

}
