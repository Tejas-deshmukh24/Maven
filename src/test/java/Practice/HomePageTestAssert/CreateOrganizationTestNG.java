package Practice.HomePageTestAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPagePOM;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPhone;
import com.comcast.crm.ObjectRepositoryUtility.TrobleTicketPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

import BaseClassTestNG.BaseClass;
import junit.framework.Assert;

public class CreateOrganizationTestNG extends BaseClass {

	@Test

	public void CreateOrganizationTestNG() throws Throwable {
		String organizationname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
		cp.createorg(organizationname);

		OrganizationInfoPage oi = new OrganizationInfoPage(driver);
		String actOrgName = oi.getHeaderMsg().getText();

		if (actOrgName.contains(organizationname)) {
			System.out.println(organizationname + "name is verified==PASS");
		} else {
			System.out.println(organizationname + "name is not verified==FAIL");
		}
	}

	@Test
	public void CreateOrganizationIndustry() throws Throwable {

		String orgName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("org", 4, 3);
		String phone = elib.getDataFromExcel("contact", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
		cp.getIndustrybtn().click();
		cp.createorgInd(orgName, phone, industry);

		OrganizationInfoPage oi = new OrganizationInfoPage(driver);
		
		String actIndustry = cp.getIndustrybtn().getText();
		boolean status = actIndustry.contains(industry);
		Assert.assertEquals(status, true);
		
		String actphoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		SoftAssert soft = new SoftAssert();
		Assert.assertEquals(actphoneNumber, phone);         
	}

	
	@Test

	public void CreateOrganizationWithPhone() throws Throwable {

		String organizationname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("org", 4, 3);
		String phone = elib.getDataFromExcel("contact", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		OrganizationPhone cp = new OrganizationPhone(driver);
		cp.getPhonebtn().click();
		cp.createorg(organizationname, phone);
		
		

		String actphoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actphoneNumber.equals(phone)) {
			System.out.println(phone + "is created==PASS");
		} else {
			System.out.println(phone + "is not created==FAIL");
		}

	}

}