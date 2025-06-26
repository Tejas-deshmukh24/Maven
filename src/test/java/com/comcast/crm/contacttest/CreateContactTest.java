package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		
		//Create Object:
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
	    JavaUtility jlib=new JavaUtility();
	    WebDriverUtility wlib = new WebDriverUtility();

	    
		String Browser=flib.getDataFromPropertiesFile("browser");
		String Url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		
		
	/*	File Utility:
		Random random = new Random();
		int randomInt= random.nextInt(1000);
	    String lastName=elib.getDataFromExcel("contact", 1, 2)+randomInt;*/
		
		
	//  Webdriver Uility:
		String lastName=elib.getDataFromExcel("contact", 1, 2)+ jlib.getRandomNumber();
		
		
    WebDriver driver =new ChromeDriver();
    wlib.waitForPageToLoad(driver);
	driver.get(Url);
		
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("(//img[@title='Create Contact...'])[1]")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		
		driver.findElement(By.xpath("(//input[contains(@title,'Save [Alt+S]')])[2]")).click();

		
		//Verify header phone number info expected result:
		
		String actlastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actlastName.equals(lastName))
		{
		System.out.println(lastName+ "is created==PASS");
		}
		else
		{
		System.out.println(lastName+ "is not created==FAIL");
		}
		driver.close();	

	}

}
