package com.comcast.crm.BaseTestng;

import java.util.Date;

public class ListenerCaptureTimeStamp {
	
	public static void main(String[] args) {
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(time);
	}

}
