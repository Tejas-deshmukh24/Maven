package com.comcast.crm.BaseTestng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClassTestNG.BaseClass;

@Listeners(com.comcast.ListenerUtility.ListImpClass.class)
public class Listener_InvoiceTest extends BaseClass {
	
	@Test
	
	public void createInvoiceTest() {
		System.out.println("Execute createInvoiceTest ");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	@Test
	public void createInvoiceContactTest() {
		System.out.println("Execute createInvoiceContactTest ");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
