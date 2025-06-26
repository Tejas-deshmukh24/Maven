package com.comcast.crm.BaseTestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPagePOM;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.TrobleTicketPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

import BaseClassTestNG.BaseClass;

public class Createcontacttest_smoketest extends BaseClass{

		@Test(groups = {"smokeTest"})

		public void createContactTest() throws Throwable {

					//read test script data from excel file

					String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

					//Navigate to Contacts module

					HomePage hp= new HomePage(driver);

					hp.getContactlink().click();

					//click on create organization button

					ContactPage cp=new ContactPage(driver);

					cp.getCreatecontactbtn().click();

					
					//Enter all the details and create new organization

					ContactPage ncp= new ContactPage(driver);

					ncp.getLastnamebtn().sendKeys(lastname);

					ncp.getLastnamebtn().click();

					

					//verify org

					ContactPage conInfo=new ContactPage(driver);
				

					String ActlastName = conInfo.getLastnamebtn().getText();

					if(ActlastName.contains(lastname)) {

						System.out.println(lastname+" Info is Veified==PASS");					

					}

					else {

						System.out.println(lastname+" Info is NotVeified==FAIL");					

					}

		}
		
		@Test(groups = "regressionTest")
		public void CreateOrganizationTest() throws Throwable {
			
			String organizationname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
			String contactLastName = elib.getDataFromExcel("contact", 7, 3);                                      

			
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
	}
	
	
		
     @Test(groups = "regressionTest")
     
     public void CreateContactWithSupportDate() throws Throwable {
			
     
     
		String TroubleTicket = elib.getDataFromExcel("troubleticket", 1, 2) + jlib.getRandomNumber();                                      
		String Status = elib.getDataFromExcel("troubleticket", 1, 5);                                      

			
	  TrobleTicketPage  TT = new TrobleTicketPage (driver);
	  
	    TT.getTroubleticketbtn().click();
	    
		TT.getCreatetroubleticket().click();
		
		TT.createtroubleticket(TroubleTicket);
		
	    
}
}




