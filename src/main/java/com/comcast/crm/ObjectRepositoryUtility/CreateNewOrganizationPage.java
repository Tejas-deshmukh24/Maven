package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	
	 WebDriver driver; 
     public CreateNewOrganizationPage(WebDriver driver) {
  	 this.driver=driver;
  	 PageFactory.initElements(driver, this);	
   }
	
    @FindBy(id ="dtlview_Industry")
 	private WebElement actindustry;
    
	@FindBy(name="accountname")
	private WebElement orgnameedt;
	
	@FindBy(xpath = "(//input[contains(@title,'Save [Alt+S]')])[1]")
	private WebElement savebtn;

	@FindBy(name = "industry")
	private WebElement industrybtn;
	
	@FindBy(id = "phone")
	private WebElement phonebtn;
	
	
	public WebElement getActindustry() {
		return actindustry;
	}

	public WebElement getOrgnameedt() {
		return orgnameedt;
	}

	public WebElement getIndustrybtn() {
		return industrybtn;
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
	
	public void createphone(String phone) {
		orgnameedt.sendKeys(phone);
		savebtn.click();
	}    
	
	
	public void createorgInd(String orgName, String phone, String industry) {
		orgnameedt.sendKeys(orgName);
		phonebtn.sendKeys(phone);
		Select sel = new Select(industrybtn);
		sel.selectByVisibleText(industry);
		savebtn.click();
	}
		
}
