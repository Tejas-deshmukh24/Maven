package CreateOrganizationPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPagePOM;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganizationIndustryPOM2 {
	
	public static void main(String[] args) throws Throwable {
		
	
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
    JavaUtility jlib=new JavaUtility();
    WebDriverUtility wlib = new WebDriverUtility();

	String Browser=flib.getDataFromPropertiesFile("browser");
	String Url=flib.getDataFromPropertiesFile("url");
	String Username=flib.getDataFromPropertiesFile("username");
	String Password=flib.getDataFromPropertiesFile("password");
	
	String orgName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
	String industry = elib.getDataFromExcel("org", 4, 3);
	String phone = elib.getDataFromExcel("contact", 7, 3);                                      

	                                     

	WebDriver driver =new ChromeDriver();
	  wlib.waitForPageToLoad(driver);
	  driver.get(Url);
   
	  LoginPagePOM lp = new LoginPagePOM(driver);
	  lp.logintoapp("admin", "admin");
	  
	  HomePage hp = new HomePage(driver); 
	  hp.getOrglink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
		cp.getIndustrybtn().click();
		cp.createorgInd(orgName, phone, industry);
		
		
		
		OrganizationInfoPage oi = new OrganizationInfoPage(driver);
		String actIndustry=driver.findElement(By.id("dtlview_Industry")).getText();
		if(actIndustry.equals(industry))
		{
		System.out.println(industry + "is verified==PASS");
		}
		else {
			System.out.println(industry + "is not verified==FAIL");
		}
		
		
		hp.logout();
		
	    driver.quit();
	

		}

	}

	  	


