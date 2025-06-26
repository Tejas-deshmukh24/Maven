package PracticeGenericUtilityFile;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtilityFlipkart {
	
	public String getDataFromPropertyFile(String Key) throws Throwable {
		
		FileInputStream flip=new FileInputStream("./configAppData/flipkart.properties");
		Properties prob=new Properties();
		prob.load(flip);
		String data=prob.getProperty(Key);
		return data;
	}
	

}
