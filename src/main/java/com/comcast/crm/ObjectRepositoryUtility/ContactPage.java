package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	WebDriver driver;
	public ContactPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(linkText  = "Contacts")
	private WebElement contactbtn;

	@FindBy(xpath = "(//img[@title='Create Contact...'])[1]")
	private WebElement createcontactbtn;

	@FindBy(name = "lastname")
	private WebElement lastnamebtn;

	@FindBy(id = "mobile")
	private WebElement mobilenobtn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;

	@FindBy(linkText = "Sign Out")
	private WebElement singout;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactbtn() {
		return contactbtn;
	}

	public WebElement getCreatecontactbtn() {
		return createcontactbtn;
	}

	public WebElement getLastnamebtn() {
		return lastnamebtn;
	}

	public WebElement getMobilenobtn() {
		return mobilenobtn;
	}
	

	public void createcontact(String lastname) {
		lastnamebtn.sendKeys(lastname);
		//savebtn.click();
	} 

	public void createcontact(String lastname, String phonenumber) {
		lastnamebtn.sendKeys(lastname);
		mobilenobtn.sendKeys(phonenumber);
		savebtn.click();
	}

	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		singout.click();
	}
}
