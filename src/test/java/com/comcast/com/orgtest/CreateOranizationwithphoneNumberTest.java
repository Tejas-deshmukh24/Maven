package com.comcast.com.orgtest;

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

public class CreateOranizationwithphoneNumberTest {

	public static void main(String[] args) throws Throwable {
		

		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
	    JavaUtility jlib=new JavaUtility();
	    WebDriverUtility wlib = new WebDriverUtility();

	    
		String Browser=flib.getDataFromPropertiesFile("browser");
		String Url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		
		
	//  Webdriver Uility:
	   // String lastName=elib.getDataFromExcel("contact", 1, 2)+ jlib.getRandomNumber();
	    String organizationname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		String contactLastName = elib.getDataFromExcel("contact", 7, 3);	
		
			
    WebDriver driver =new ChromeDriver();
    wlib.waitForPageToLoad(driver);
	driver.get(Url);
		
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("(//img[@title='Create Organization...'])[1]")).click();
		driver.findElement(By.name("accountname")).sendKeys(organizationname);
		
		driver.findElement(By.id("phone")).sendKeys(contactLastName);
		
		
		driver.findElement(By.xpath("(//input[contains(@title,'Save [Alt+S]')])[2]")).click();

		
		//Verify header phone number info expected result:
		
		String actphoneNumber=driver.findElement(By.id("dtlview_Phone")).getText();
		if(actphoneNumber.equals(contactLastName))
		{
		System.out.println(contactLastName+ "is created==PASS");
		}
		else {
			System.out.println(contactLastName+ "is not created==FAIL");
		}
		driver.close();
	

	}

}
