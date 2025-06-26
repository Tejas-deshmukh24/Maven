package TestNG.Package_Sample;



import org.testng.annotations.Test;

public class CreateContactTestBeforeAfter extends BaseClassBeforeAfterTest {
	
	
	
	@Test
	public void CreateContact(){
		System.out.println("==Execute Create Contact & Verify==");
	}
	
	@Test
	public void CreateContactWithDate(){
		System.out.println("==Execute Create Contact With Date & Verify==");
	}
	

}
