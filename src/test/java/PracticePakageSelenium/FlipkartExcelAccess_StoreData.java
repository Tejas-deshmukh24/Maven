package PracticePakageSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.Org_ContactExcelUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;

public class FlipkartExcelAccess_StoreData {

	@Test
	public void getProductInfoTest(String brandName , String productName) throws Throwable {
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("iphone"+Keys.ENTER);
		 WebElement x = driver.findElement(By.xpath("//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div/div[1]/div[1]/a/span/span[2]/span[2]"));		
         System.out.println(x.getText());	
         String price = x.getText();
         
         
	
	   FileInputStream fis = new FileInputStream("./TestData/flipkart.xlsx");
       Workbook wb = WorkbookFactory.create(fis);
       
       wb.getSheet("Sheet1").createRow(0).createCell(2).setCellValue("price");
       
       FileOutputStream fos = new FileOutputStream("./TestData/flipkart.xlsx");
       wb.write(fos);
       wb.close();
       
       driver.quit();
	
	}

}

