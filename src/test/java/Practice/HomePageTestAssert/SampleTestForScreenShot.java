package Practice.HomePageTestAssert;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
	
	@Test
	
	public void amazontest() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
//  	step-1: Create an object to evenfiring webdriver:
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		
//      step-2: Use getScreenshotAs method to get file type of screenshot:
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
//  	step-3: Store screenshot in local drive:
		FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
		
			
	}

}
