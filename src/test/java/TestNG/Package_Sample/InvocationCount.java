package TestNG.Package_Sample;

import org.testng.annotations.Test;

public class InvocationCount {
	
	@Test(invocationCount = 10)
	public void createOrdrerTest() {
		System.out.println("Execute createOrderTest==>123");
	}
	
	@Test(enabled = false)
	public void billingAnOrderTest() {
		System.out.println("Execute billingAnOrderTest==>123");
	}

}
