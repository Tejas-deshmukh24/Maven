package CreateContactPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectRepositoryUtility.ContactInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.ContactWithSupportDate;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPagePOM;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithSupportDateTestPOM3 {
	
	public static void main(String[] args) throws Throwable {
		

		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String Browser = flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url");
		String Username = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");

		String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		String phonenumber = elib.getDataFromExcel("contact", 1, 3);

		WebDriver driver=null;
		//Launching browser
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if(Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		wlib.waitForPageToLoad(driver);
		driver.get(Url);

		LoginPagePOM lp = new LoginPagePOM(driver);

		lp.logintoapp("admin", "admin");
		

		HomePage hp= new HomePage(driver);
		hp.getContactlink().click();
		
		//Navigate to Contacts mo
		//click on create new contact button
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactbtn().click();
		
		//Enter all the details and create new organization
		ContactWithSupportDate ncp= new ContactWithSupportDate(driver);
		ncp.getLastNameEdt().sendKeys(lastname);
		ncp.getStaretDate().clear();
		ncp.getStaretDate().sendKeys(jlib.getSystemDateYYYYDDMM());
		ncp.getEndDate().clear();
		ncp.getEndDate().sendKeys(jlib.getRequiredDateYYYYDDMM(30));
		ncp.getSaveContactBtn().click();
		
		String curDate = jlib.getSystemDateYYYYDDMM();
		String endDate = jlib.getRequiredDateYYYYDDMM(30); 
		
		//verify orgname in 
		ContactInfoPage conInfo=new ContactInfoPage(driver);
		String ActStartDate = conInfo.getStartDateText().getText();
		if(ActStartDate.contains(curDate)) {
			System.out.println(curDate+" Info is Veified==PASS");					
		}
		else {
			System.out.println(curDate+" Info is NotVeified==FAIL");					
		}
						
		String ActEndDate = conInfo.getEndDateText().getText();
		if(ActEndDate.contains(endDate)) {
			System.out.println(endDate+" Info is Veified==PASS");					
		}
		else {
			System.out.println(endDate+" Info is NotVeified==FAIL");					
		}
		//logout from application
		hp.logout();
		driver.quit();
	}

}

