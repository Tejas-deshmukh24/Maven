package POMRepository;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.grid.Main;


import com.comcast.crm.ObjectRepositoryUtility.LoginPagePOM;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.ProductPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateProductPagePOM {
	
	public static void main(String[] args) throws Throwable {
	
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
    JavaUtility jlib=new JavaUtility();
    WebDriverUtility wlib = new WebDriverUtility();

	String Browser=flib.getDataFromPropertiesFile("browser");
	String Url=flib.getDataFromPropertiesFile("url");
	String Username=flib.getDataFromPropertiesFile("username");
	String Password=flib.getDataFromPropertiesFile("password");
	
	String product = elib.getDataFromExcel("product", 4, 2) + jlib.getRandomNumber();                                      

		
  WebDriver driver =new EdgeDriver();
  wlib.waitForPageToLoad(driver);
  driver.get(Url);

  LoginPagePOM lp = new LoginPagePOM(driver);

  lp.logintoapp("admin", "admin");
  
  ProductPage pp = new ProductPage(driver);
  
    pp.getProduct().click();
    
	pp.getCreateproductbtn().click();
	
	pp.createproductpage(product);
	
    pp.logout();
  
    driver.close();
  
	}
}
