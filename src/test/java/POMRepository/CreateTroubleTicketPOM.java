package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.ObjectRepositoryUtility.LoginPagePOM;
import com.comcast.crm.ObjectRepositoryUtility.ProductPage;
import com.comcast.crm.ObjectRepositoryUtility.TrobleTicketPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateTroubleTicketPOM {
	
	public static void main(String[] args) throws Throwable {
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
	    JavaUtility jlib=new JavaUtility();
	    WebDriverUtility wlib = new WebDriverUtility();

		String Browser=flib.getDataFromPropertiesFile("browser");
		String Url=flib.getDataFromPropertiesFile("url");
		String Username=flib.getDataFromPropertiesFile("username");
		String Password=flib.getDataFromPropertiesFile("password");
		
		String TroubleTicket = elib.getDataFromExcel("troubleticket", 1, 2) + jlib.getRandomNumber();                                      
		String Status = elib.getDataFromExcel("troubleticket", 1, 5);                                      

			
	  WebDriver driver =new EdgeDriver();
	  wlib.waitForPageToLoad(driver);
	  driver.get(Url);

	  LoginPagePOM lp = new LoginPagePOM(driver);

	  lp.logintoapp("admin", "admin");
	  
	  TrobleTicketPage  TT = new TrobleTicketPage (driver);
	  
	    TT.getTroubleticketbtn().click();
	    
		TT.getCreatetroubleticket().click();
		
		TT.createtroubleticket(TroubleTicket);
		
	    TT.logout();
	  
	    driver.close();

}
}
