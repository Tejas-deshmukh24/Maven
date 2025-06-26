package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TrobleTicketPage {
	
	WebDriver driver;
	public TrobleTicketPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

   @FindBy(linkText = "Trouble Tickets")
   private WebElement troubleticketbtn;
   
   @FindBy(xpath = "(//img[@title='Create Ticket...'])[1]")
   private WebElement createtroubleticketbtn;
   
   @FindBy(name = "ticket_title")
   private WebElement titlename;
   
   @FindBy(name = "ticketstatus")
   private WebElement ticketstatusbtn;
   
   @FindBy(name = "button")
   private WebElement savebtn;
   
   @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
   private WebElement adminimg;
	
   @FindBy(linkText = "Sign Out")
   private WebElement singout;
	
   
   
public WebDriver getDriver() {
	return driver;
}

public WebElement getTroubleticketbtn() {
	return troubleticketbtn;
}

public WebElement getCreatetroubleticket() {
	return createtroubleticketbtn;
}

public WebElement getTitlename() {
	return titlename;
}

public WebElement getTicketstatus() {
	return ticketstatusbtn;
}

public WebElement getSavebtn() {
	return savebtn;
}
  
public void createtroubleticket(String ticketname) {
	titlename.sendKeys(ticketname);
	savebtn.click();
}    

public void createtroubleticket(String ticketname, String ticketstatus) {
	titlename.sendKeys(ticketname);
	Select sel = new Select(ticketstatusbtn);
	sel.selectByVisibleText(ticketstatus);
	savebtn.click();
}

public void logout() {
	Actions act = new Actions(driver);
	act.moveToElement(adminimg).perform();
	singout.click();
}

}

   
   
   
   
	


