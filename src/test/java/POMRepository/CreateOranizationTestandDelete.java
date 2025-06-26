package POMRepository;

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
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPagePOM;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

import graphql.org.antlr.v4.runtime.tree.xpath.XPath;


public class CreateOranizationTestandDelete {

	public static void main(String[] args) throws Throwable {
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
	    JavaUtility jlib=new JavaUtility();
	    WebDriverUtility wlib = new WebDriverUtility();

		String Browser=flib.getDataFromPropertiesFile("browser");
		String Url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		
		  String organizationname = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		//String contactLastName = elib.getDataFromExcel("contact", 7, 3);                                      

			
    WebDriver driver =new EdgeDriver();
    wlib.waitForPageToLoad(driver);
	driver.get(Url);
	
	LoginPagePOM lp = new LoginPagePOM(driver);
	
  //LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
/*	lp.getUsernameEdt().sendKeys("admin");
	lp.getPasswordEdt().sendKeys("admin");
	lp.getLoginBtn().click();	                */
	
	//OR//
	
	lp.logintoapp("admin", "admin");
	
	//Navigate to organization module:
	HomePage hp = new HomePage(driver); 
	hp.getOrglink().click();
	
	//Click on create organization btn:
	OrganizationPage op = new OrganizationPage(driver);
	op.getCreateNewOrgBtn().click();
	
	//Create new orgpage:
	CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
	cp.createorg(organizationname);
	
	//Header message expected result:
	
	OrganizationInfoPage oi = new OrganizationInfoPage(driver);
	String actOrgName = oi.getHeaderMsg().getText();
	
	if(actOrgName.contains(organizationname))
	{
		System.out.println(organizationname+ "name is verified==PASS");
	}else {
		System.out.println(organizationname+ "name is not verified==FAIL");
	}
	
	//Go back to orgpage and search for org in dynamic select and delete:
	hp.getOrglink().click();
	
	//Search for org:
	op.getSearchedt().sendKeys(organizationname);
	wlib.selectByIndexMethod(driver.findElement(By.id("bas_searchfield")), 1);
	op.getSearchedt().click();
	
	//In dynamic webtable select & delete org:

	driver.findElement(By.xpath("//a[text()='" + organizationname + "']/../../td[8]//a[text()='del']")).click();

	hp.logout();
	
    driver.quit();
	
	}

}
