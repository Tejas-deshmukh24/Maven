package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {
	
	WebDriver driver;
    public OrganizationPage(WebDriver driver) {
  	this.driver=driver;
  	PageFactory.initElements(driver, this);	
   }
    
    @FindBy(name = "search_text")
	private WebElement searchedt;

	@FindBy(name = "search_field")
	private WebElement searchfield;
    
    @FindBy(name = "submit")
	private WebElement submit;

	@FindBy(xpath = "(//img[@title='Create Organization...'])[1]")
	private WebElement createNewOrgBtn;

	
	
	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public WebElement getSearchedt() {
		return searchedt;
	}

	public WebElement getSearchfield() {
		return searchfield;
	}	

	

}
