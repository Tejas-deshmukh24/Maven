package BaseClassTestNG;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeSuite;

import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.generic.DataUtility.DataBaseU;

import com.comcast.crm.generic.fileutility.ExcelUtility;

import com.comcast.crm.generic.fileutility.FileUtility;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;





public class BaseClassConfigAnnotation {

		public static WebDriver driver= null;

		//creation of object

		public static DataBaseU dblib= new DataBaseU();

		public static FileUtility flib= new FileUtility();

		public static ExcelUtility elib= new ExcelUtility();

		public static JavaUtility jlib= new JavaUtility();

		public static WebDriverUtility wlib;



		@BeforeSuite

		public void configBS() throws SQLException {

			System.out.println("===Connect To DB, Report Config===");

			dblib.getDbconnection();

		}

		

		@BeforeClass

		public void configBC() throws Throwable {

			System.out.println("==Launch Browser==");

			String BROWSER = flib.getDataFromPropertiesFile("browser");

			System.out.println("B:"+BROWSER);

			if(BROWSER.equals("chrome")) {

				driver=new ChromeDriver();

			}else if (BROWSER.equals("firefox")) {

				driver=new FirefoxDriver();

			}else if (BROWSER.equals("edge")) {

				driver=new EdgeDriver();

			}else {

				driver=new ChromeDriver();

			}

			 wlib=new WebDriverUtility();

		}

		

		@BeforeMethod 

		public void configBM() throws Throwable {

			System.out.println("==Login==");

			String url = flib.getDataFromPropertiesFile("url");

			String username = flib.getDataFromPropertiesFile("username");

			String password = flib.getDataFromPropertiesFile("password");

			LoginPage lp=new LoginPage(driver);

			lp.loginToApp(url, username, password);
			

		}

		

		@AfterMethod

		public void configAM() {

		System.out.println("==LogOut==");

		HomePage hp=new HomePage(driver);

		hp.logout();

		}

		

		@AfterClass

		public void configAC() {

			System.out.println("==close browse==");

			driver.quit();

		}

		

		@AfterSuite

		public void configAS() throws SQLException {

			System.out.println("===close DB, Report BackUp");

			dblib.closeDbconnection();
		}
}
