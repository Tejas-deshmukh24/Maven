package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestwithPom {
	
	@FindBy(name="user_name")
	WebElement ele1;
	
	@FindBy(name="user_password")
	WebElement ele2;
	
	@FindAll({@FindBy(id="submitButton"), @FindBy(xpath = "//input[@value='Login']")})
	WebElement ele3;

	
	@Test
     public void sampleTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://49.249.28.218:8888/");
		
		SampleTestwithPom s = PageFactory.initElements(driver, SampleTestwithPom.class);
		
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("admin");
		
		s.ele3.click();
		
		driver.close();
	}

}
