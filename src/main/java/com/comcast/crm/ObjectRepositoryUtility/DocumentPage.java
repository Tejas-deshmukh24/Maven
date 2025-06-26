package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DocumentPage {
	
	WebDriver driver;
	public DocumentPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

   @FindBy(linkText = "Documents")
   private WebElement documentbtn;
   
   @FindBy(xpath = "(//img[@title='Create Document...'])[1]")
   private WebElement createdocumentbtn;
   
   @FindBy(name = "notes_title")
   private WebElement createtitlebtn;
   
   @FindBy(name = "button")
   private WebElement savebtn;
   
   @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
  	private WebElement adminimg;
  	
  	@FindBy(linkText = "Sign Out")
  	private WebElement singout;
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getDocumentbtn() {
		return documentbtn;
	}

	

	public WebElement getCreatedocumentbtn() {
		return createdocumentbtn;
	}

	
	public WebElement getCreatetitle() {
		return createtitlebtn;
	}

	
	public WebElement getSavebtn() {
		return savebtn;
	}

	
	public WebElement getAdminimg() {
		return adminimg;
	}

	public void setAdminimg(WebElement adminimg) {
		this.adminimg = adminimg;
	}
  	
	public void createdocument(String titlename) {
		createtitlebtn.sendKeys(titlename);
		savebtn.click();
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		singout.click();
	}
}
