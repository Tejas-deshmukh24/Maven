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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOranizationwithIndustryTest {

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
		String industry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 4);
		
		
	
    WebDriver driver =new ChromeDriver();
    wlib.waitForPageToLoad(driver);
	driver.get(Url);
		
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("(//img[@title='Create Organization...'])[1]")).click();
		driver.findElement(By.name("accountname")).sendKeys(organizationname);
		
		WebElement Wb1 = driver.findElement(By.name("industry"));
		Select sel1=new Select(Wb1);
		sel1.selectByVisibleText(industry);
		
		WebElement Wb2 = driver.findElement(By.name("accounttype"));
		Select sel2=new Select(Wb2);
		sel2.selectByVisibleText(type);
		
		driver.findElement(By.xpath("(//input[contains(@title,'Save [Alt+S]')])[2]")).click();
	
		
		//Verify the dropdown industry and type info:
		String actIndustry=driver.findElement(By.id("dtlview_Industry")).getText();
		if(actIndustry.equals(industry))
		{
		System.out.println(industry + "is verified==PASS");
		}
		else {
			System.out.println(industry + "is not verified==FAIL");
		}
		
		
		String actType=driver.findElement(By.id("dtlview_Type")).getText();
		if(actType.equals(type))
		{
		System.out.println(type + "is verified==PASS");
		}
		else {
			System.out.println(type + "is not verified==FAIL");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.close();
	

	}

}
