package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactwithorgTest {

	public static void main(String[] args) throws Throwable {

		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String Browser = flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url");
		String Username = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");

		String organizationname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		String contactLastName = elib.getDataFromExcel("contact", 7, 3);

		WebDriver driver = new ChromeDriver();
		wlib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(Url);

		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("(//img[@title='Create Organization...'])[1]")).click();
		driver.findElement(By.name("accountname")).sendKeys(organizationname);
		driver.findElement(By.xpath("(//input[contains(@title,'Save [Alt+S]')])[2]")).click();

		// Verify header message expected result:
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(organizationname)) {
			System.out.println(organizationname + "is created==PASS");
		} else {
			System.out.println(organizationname + "is not created==FAIL");
		}

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("(//img[@title='Create Contact...'])[1]")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		Set<String> set= driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
			String windowID=it.next();
			driver.switchTo().window(windowID);
			
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains("module=Accounts")) {
				break;
			}
		}
		
		driver.findElement(By.name("search_text")).sendKeys(organizationname);
		driver.findElement(By.name("search")).click();

		driver.findElement(By.xpath("//a[text()='" + organizationname + "']")).click();

		
		// switch to child window:
		wlib.switchToTabOnURL(driver, "Contact&action");

		
		
		driver.findElement(By.xpath("(//input[contains(@title,'Save [Alt+S]')])[2]")).click();

		// Verify header phone number info expected result:

		headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(contactLastName)) {
			System.out.println(contactLastName + "is created==PASS");
		} else {
			System.out.println(contactLastName + "is not created==FAIL");
		}

		// Verify header organizationname info expected result:

		String actorganizationname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actorganizationname);
		if (actorganizationname.trim().equals(organizationname)) {
			System.out.println(organizationname + "is created==PASS");
		} else {
			System.out.println(organizationname + "is not created==FAIL");
		}

		driver.quit();

	}

}
