package TestNG.Package_Sample;

import org.testng.annotations.Test;

public class CreateOrgTestBeforeAfter extends BaseClassBeforeAfterTest {
	
	@Test
	public void CreateOrganization(){
		System.out.println("==Execute Create Organization & Verify==");
	}
	
	@Test
	public void CreateOrganizationWithIndustries(){
		System.out.println("==Execute Create Organization With Industries & Verify==");
	}
}

