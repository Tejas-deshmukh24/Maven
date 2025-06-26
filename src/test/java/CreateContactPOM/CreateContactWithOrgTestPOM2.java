package CreateContactPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectRepositoryUtility.ContactInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.ContactWithSupportDate;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPagePOM;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtilityPOM;

public class CreateContactWithOrgTestPOM2{
	
	public static void main(String[] args) throws Exception {
		
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
/*		WebDriverUtilityPOM wlib = new WebDriverUtilityPOM();

		String Browser = flib.getDataFromPropertiesFile("browser");
		String Url = flib.getDataFromPropertiesFile("url");
		String Username = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");

		String orgName = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
		String lastname = elib.getDataFromExcel("contact", 7, 3) + jlib.getRandomNumber();
		
		                                          
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
		

//		wlib.waitForPageToLoad(driver);
		driver.get(Url);

		LoginPagePOM lp = new LoginPagePOM(driver);

		lp.logintoapp("admin", "admin");
	
				
				//Navigate to Organization module
				HomePage hp= new HomePage(driver);
				hp.getOrglink().click();
				
				//click on create organization button
				OrganizationPage orgP= new OrganizationPage(driver);
				orgP.getCreateNewOrgBtn().click();
			
				//Enter all the details and create new organization
				CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
				cnop.getOrgnameedt().sendKeys(orgName);
				cnop.getSavebtn().click();
				
				//verify header msg expected result
				OrganizationInfoPage orgInfoPage=new OrganizationInfoPage(driver);
				String actHeadeInfo = orgInfoPage.getHeaderMsg().getText();
				if(actHeadeInfo.contains(orgName)) {
					System.out.println(orgName+" header is Verified==PASS");			
				}else {
					System.out.println(orgName+" header is not Verified==FAIL");
				}
				
				//Navigate to Contacts module
				hp.getContactlink().click();
				
				//click on create organization button
				ContactPage cp= new ContactPage(driver);
				cp.getCreatecontactbtn().click();
				
				//Enter all the details and create new organization
				ContactWithSupportDate cncp=new ContactWithSupportDate(driver);
				cncp.getLastNameEdt().sendKeys(lastname);
				cncp.getOrgLookUpBtn().click();
				
				//switch to child window
//				wlib.switchToWin();	
				OrganizationPage op=new OrganizationPage(driver);
				op.getSearchedt().sendKeys(orgName);
				op.getSearchedt().click();
								 
				driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
				
				//switch to parent window
//				wlib.switchToParentWindow();
				//wlib.switchToTabOnURL(driver, "Contacts&parenttab");
				

				driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
				
				
				//verify header msg expected result
				ContactInfoPage cip=new ContactInfoPage(driver);
				String headerinfo = cip.getContactHeaderText().getText();
				if(headerinfo.contains(lastname)) {
					System.out.println(lastname+" contact is Created==PASS");			
				}else {
					System.out.println(lastname+" contact is not created==FAIL");
				}
				
				//verify hader orgname info expected resulted
				String actOrgName = cip.getOrgText().getText();	
				if(actOrgName.contains(orgName)) {
					System.out.println(orgName+" contact with org is Created==PASS");			
				}else {
					System.out.println(orgName+" contact with org is not created==FAIL");
				}
				 
				//logout from application
				driver.quit();		                       */

	}

}



