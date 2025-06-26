package Practice.HomePageTestAssert;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HomePageSampleTestReport {
	
	@Test
	public void homepagetest(Method mtd) {
		
		Reporter.log(mtd.getName() +"Test Start");
		Reporter.log("Step-1", true);
		Reporter.log("Step-2", true);
		Reporter.log("Step-3", true);
		Reporter.log("Step-4", true);
		Reporter.log(mtd.getName() +"Test End");
	}
	
    @Test
    public void verifylogohomepagetest(Method mtd) {
    	
    	Reporter.log(mtd.getName() +"Test Start");
    	Reporter.log(mtd.getName() +"Test Start");
		Reporter.log("Step-1", true);
		Reporter.log("Step-2", true);
		Reporter.log("Step-3", true);
		Reporter.log("Step-4", true);
		Reporter.log(mtd.getName() +"Test End");
	}
}
    	