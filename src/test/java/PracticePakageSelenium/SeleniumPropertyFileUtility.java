package PracticePakageSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

import PracticeGenericUtilityFile.FileUtilityFlipkart;

public class SeleniumPropertyFileUtility {

	public static void main(String[] args) throws Throwable {
		
		FileUtilityFlipkart flip=new FileUtilityFlipkart();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
	    WebDriverUtility wlib = new WebDriverUtility();

		
		String browser=flip.getDataFromPropertyFile("browser");
		String url=flip.getDataFromPropertyFile("url");
		String search=flip.getDataFromPropertyFile("search");
		
		String Mobile = elib.getDataFromExcel("flipkart", 1, 2) + jlib.getRandomNumber();
		String Shoes = elib.getDataFromExcel("flipkart", 7, 3);                                      

		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.className("Pke_EE")).sendKeys(search);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	    driver.close();

	}

}
