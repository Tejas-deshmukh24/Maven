package PracticeGenericUtilityFile;

import java.io.FileInputStream;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.xml.internal.Parser;

public class JsonUtilityFlipkart {
	
	public String getDatafromJson(String key) throws Throwable {
		
FileReader fileR=new FileReader("./configAppData/Fipkart.json");
		
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fileR);
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("url"));
		
		String data= (String) map.get(key);
		return data;
		
		

		
	}

	
}
