package TestNG.Package_Sample;

import org.testng.annotations.Test;

public class OrderTest {
	
	@Test
	public void createOrdrerTest() {
		System.out.println("Execute createOrderTest with==>HDFC");
	}
	
	@Test(dependsOnMethods = "createOrderTest")
	public void modifyOrderTest() {
		System.out.println("Execute modifyOrderTest==>HDFC=>ICICI");
	}
	
	@Test(dependsOnMethods = "modifyOrderTest")
	public void deleteOrderTest() {
		System.out.println("Execute deleteOrderTest ICICI");
	}

}
