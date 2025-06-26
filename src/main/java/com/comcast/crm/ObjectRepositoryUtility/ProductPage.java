package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;
	public ProductPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Products")
	private WebElement product;
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createproductbtn;
	
	@FindBy(name = "productname")
	private WebElement productnamebtn;
	
	@FindBy(name = "button")
	private WebElement savebtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement singout;
	
	
	/*public WebDriver getDriver() {
		return driver;
	}*/

	public WebElement getProduct() {
		return product;
	}

	public WebElement getCreateproductbtn() {
		return createproductbtn;
	}

	public WebElement getProductname() {
		return productnamebtn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	
	public void createproductpage(String productname) {
		productnamebtn.sendKeys(productname);
		savebtn.click();	
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		singout.click();
	}

}
