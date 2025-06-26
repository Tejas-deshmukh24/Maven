package CreateContactPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPagePOM;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactLastNamePOM1 {

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
		
		ContactPage CP = new ContactPage(driver);

		CP.getContactbtn().click();

		CP.getCreatecontactbtn().click();

		CP.createcontact(lastname);

		CP.createcontact(phonenumber);
		
		Thread.sleep(2000);

		CP.logout();

		driver.close();

	}
}
