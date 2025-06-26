package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.ObjectRepositoryUtility.DocumentPage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPagePOM;
import com.comcast.crm.ObjectRepositoryUtility.TrobleTicketPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateDocumentModulePOM {

public static void main(String[] args) throws Throwable {
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
	    JavaUtility jlib=new JavaUtility();
	    WebDriverUtility wlib = new WebDriverUtility();

		String Browser=flib.getDataFromPropertiesFile("browser");
		String Url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		
		String Document = elib.getDataFromExcel("document", 1, 2) + jlib.getRandomNumber();                                      
		                                     
		
	  WebDriver driver =new EdgeDriver();
	  wlib.waitForPageToLoad(driver);
	  driver.get(Url);

	  LoginPagePOM lp = new LoginPagePOM(driver);

	  lp.logintoapp("admin", "admin");
	  
	  DocumentPage  DP = new DocumentPage (driver);
	  
	    DP.getDocumentbtn().click();
	    
		DP.getCreatedocumentbtn().click();
		
		DP.createdocument(Document);
		
	    DP.logout();
	  
	    driver.close();

   }
}

	

