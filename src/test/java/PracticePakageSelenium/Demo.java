package PracticePakageSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
//		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
//      Thread.sleep(3000);
		
		
/*		driver.findElement(By.linkText("Register")).click();
		WebElement firstname=driver.findElement(By.id("FirstName"));
		firstname.sendKeys("asd",Keys.TAB,"fgh", Keys.TAB,"tejasmukh225@gmail.com",Keys.TAB,"123456",Keys.TAB,"123456",Keys.ENTER); */

	WebElement search=driver.findElement(By.name("q"));
	System.out.println(search.getTagName());
//	search.sendKeys("samsung s24 ultra",Keys.ENTER);
	search.sendKeys("Leap7x GHD-89E Non Lacing Sports Shoes With EVA Sole | Suitable For Jogging & Walking Shoes For Men",Keys.ENTER);
	
//	WebElement price=driver.findElement(By.xpath("//div[text()='Samsung Galaxy S24 Ultra 5G (Titanium Gray, 256 GB)']/../../..//div[@class='Nx9bqj _4b5DiR']"));
	WebElement Shoesprice=driver.findElement(By.xpath("//span[text()='Leap7x GHD-89E Non Lacing Sports Shoes With EVA Sole | Suitable For Jogging & Walking Shoes For Men']/../../../..//div[@class='Nx9bqj CxhGGd']"));
	System.out.println(Shoesprice.getText());	
		
		
}
}