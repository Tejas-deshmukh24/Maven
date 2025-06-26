package com.comcast.crm.ContactTestNG;

import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.ContactInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.ContactWithSupportDate;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;

import BaseClassTestNG.BaseClass;

public class CreateContactTestNG extends BaseClass {

	@Test

	public void CreateContactTestNG() throws Throwable {

		String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		String phonenumber = elib.getDataFromExcel("contact", 1, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		ContactPage CP = new ContactPage(driver);

		CP.getContactbtn().click();

		CP.getCreatecontactbtn().click();

		CP.createcontact(lastname);

		CP.createcontact(phonenumber);

	}

	@Test
	public void CreateContactPhone() throws Throwable {

		String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		String phonenumber = elib.getDataFromExcel("contact", 1, 3);

		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// Navigate to Contacts mo
		// click on create new contact button
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		// Enter all the details and create new organization
		ContactWithSupportDate ncp = new ContactWithSupportDate(driver);
		ncp.getLastNameEdt().sendKeys(lastname);
		ncp.getStaretDate().clear();
		ncp.getStaretDate().sendKeys(jlib.getSystemDateYYYYDDMM());
		ncp.getEndDate().clear();
		ncp.getEndDate().sendKeys(jlib.getRequiredDateYYYYDDMM(30));
		ncp.getSaveContactBtn().click();

		String curDate = jlib.getSystemDateYYYYDDMM();
		String endDate = jlib.getRequiredDateYYYYDDMM(30);

		ContactInfoPage conInfo = new ContactInfoPage(driver);
		String ActStartDate = conInfo.getStartDateText().getText();
		if (ActStartDate.contains(curDate)) {
			System.out.println(curDate + " Info is Veified==PASS");
		} else {
			System.out.println(curDate + " Info is NotVeified==FAIL");
		}

		String ActEndDate = conInfo.getEndDateText().getText();
		if (ActEndDate.contains(endDate)) {
			System.out.println(endDate + " Info is Veified==PASS");
		} else {
			System.out.println(endDate + " Info is NotVeified==FAIL");
		}

	}

}
