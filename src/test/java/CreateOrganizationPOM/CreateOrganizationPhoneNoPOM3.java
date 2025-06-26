package CreateOrganizationPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPagePOM;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPhone;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganizationPhoneNoPOM3 {
	
public static void main(String[] args) throws Throwable {
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
	    JavaUtility jlib=new JavaUtility();
	    WebDriverUtility wlib = new WebDriverUtility();

		String Browser=flib.getDataFromPropertiesFile("browser");
		String Url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		
		String organizationname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("org", 4, 3);
		String phone = elib.getDataFromExcel("contact", 7, 3);                                      

		WebDriver driver =new EdgeDriver();
		  wlib.waitForPageToLoad(driver);
		  driver.get(Url);

		  LoginPagePOM lp = new LoginPagePOM(driver);
		  lp.logintoapp("admin", "admin");
		  	
   

	HomePage hp = new HomePage(driver); 
	hp.getOrglink().click();
	
	OrganizationPage op = new OrganizationPage(driver);
	op.getCreateNewOrgBtn().click();
	
	OrganizationPhone cp = new OrganizationPhone(driver);
	cp.getPhonebtn().click();
	cp.createorg(organizationname,phone);
	
	
	String actphoneNumber=driver.findElement(By.id("dtlview_Phone")).getText();
	if(actphoneNumber.equals(phone))
	{
	System.out.println(phone+ "is created==PASS");
	}
	else {
		System.out.println(phone+ "is not created==FAIL");
	}
	
	hp.logout();
	
    driver.quit();
	

	}

}



