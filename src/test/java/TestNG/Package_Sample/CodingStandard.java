package TestNG.Package_Sample;

import org.testng.annotations.Test;
import BaseClassTestNG.BaseClass;

/**
 * 
 * @author Tejas
 * 
 * test class for contact module
 * 
 */

public class CodingStandard extends BaseClass{
	
	/**
	 * Scenario : login()==>navigateContact==>createcontact()==>verify
	 */
	
	@Test
	public void searchcontactTest() {
		
		/*step 1 : login to app */
		LoginPage lp = new LoginPage(driver);
		lp.logintoappTestNG("url", "usernmae", "password");
		
		
	}

}
