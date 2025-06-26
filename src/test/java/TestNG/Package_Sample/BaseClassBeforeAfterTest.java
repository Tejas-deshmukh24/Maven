package TestNG.Package_Sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassBeforeAfterTest {
	
	@BeforeSuite
	public void configBeforeSuite(){
		System.out.println("==Connect to Database , Report Config==");
	}
	
	@BeforeClass
	public void configBeforeClass(){
		System.out.println("==Launch the Browser==");
	}
	
	@BeforeMethod
	public void configBeforeMethod(){
		System.out.println("==Login==");
	}
	
	@AfterMethod
	public void configAfterMethod(){
		System.out.println("==Logout==");
	}

	@AfterClass
	public void configAfterClass(){
		System.out.println("==Close the Browser==");
	}

	@AfterSuite
	public void configAfterSuite(){
		System.out.println("==Close Database , Report Backup==");
	}

}


//Select both two class CreateContact..,CreateOrg..and click on TestNG.xml converter,create this file, Execute show result both class will be common result.
