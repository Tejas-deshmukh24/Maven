package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContactwithsupportDateTest {

	public static void main(String[] args) throws Throwable {

		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String Browser = flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url");
		String Username = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");

		// Webdriver Uility:
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		driver.get(Url);

		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("(//img[@title='Create Contact...'])[1]")).click();

		String StartDate = jlib.getSystemDateYYYYDDMM();
		String EndDate = jlib.getRequiredDateYYYYDDMM(30);

		driver.findElement(By.name("lastname")).sendKeys(lastName);

		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(StartDate);

		System.out.println("E:" + EndDate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(EndDate);

		driver.findElement(By.xpath("(//input[contains(@title,'Save [Alt+S]')])[2]")).click();

		// Verify header message expected result:
		String actstartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actstartdate.equals(StartDate)) {
			System.out.println(StartDate + "is created==PASS");
		} else {
			System.out.println(StartDate + "is not created==FAIL");
		}

		String actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actenddate.equals(EndDate)) {
			System.out.println(EndDate + "is created==PASS");
		} else {
			System.out.println(EndDate + "is not created==FAIL");
		}

		driver.quit();

	}

}
