package com.comcast.crm.BaseTestng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClassTestNG.BaseClass;


public class Listener_InvoiceTestRetryAnalyzer  {
	
	@Test(retryAnalyzer = com.comcast.ListenerUtility.ReteryListenerImp.class)
	
	public void activateSim() {
		System.out.println("Execute ReteryAnalyzerTest ");
		Assert.assertEquals("", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
}
