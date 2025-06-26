package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPhone {
	
	WebDriver driver;
    public OrganizationPhone(WebDriver driver) {
  	this.driver=driver;
  	PageFactory.initElements(driver, this);	
   }
    
    @FindBy(name="accountname")
	private WebElement orgnameedt;
	
	@FindBy(xpath = "(//input[contains(@title,'Save [Alt+S]')])[1]")
	private WebElement savebtn;

	
	@FindBy(id = "phone")
	private WebElement phonebtn;
	

	
	public WebElement getOrgnameedt() {
		return orgnameedt;
	}

	
	public WebElement getPhonebtn() {
		return phonebtn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	public void createorg(String orgName) {
		orgnameedt.sendKeys(orgName);
		savebtn.click();
	}    
	
	public void createorg1(String phone) {
		orgnameedt.sendKeys(phone);
		savebtn.click();
	}    
	
	public void createorg(String orgName, String phone) {
		orgnameedt.sendKeys(orgName);
		phonebtn.sendKeys(phone);
		savebtn.click();
	}
	
	
	
}
