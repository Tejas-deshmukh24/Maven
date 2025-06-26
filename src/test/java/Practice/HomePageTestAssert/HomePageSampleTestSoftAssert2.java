package Practice.HomePageTestAssert;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTestSoftAssert2 {
	
	@Test
	public void homepagetest(Method mtd) {
		
		System.out.println(mtd.getName() +"Test Start");
		SoftAssert assertObj = new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertEquals("Home", "Home");                 //Either one execute Remove comment:
//		Assert.assertEquals("Home", "Home-Page");            //Hard Assert
		System.out.println("Step-3");
		assertObj.assertEquals("Home-CRM", "Home-CRM");      //Either one execute Remove comment:
//		assertObj.assertEquals("Title", "Title-1");          //soft Assert
		System.out.println("Step-4");
		assertObj.assertAll();                               //Print Exceptions:
		System.out.println(mtd.getName() +"Test End");
	}
	
    @Test
    public void verifylogohomepagetest(Method mtd) {
    	
 //   	System.out.println(mtd.getName() +"Test Start");
		SoftAssert assertObj = new SoftAssert();
    	System.out.println(mtd.getName() +"Test Start");
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		assertObj.assertAll(); 
		System.out.println(mtd.getName() +"Test End");
	}
}
    	