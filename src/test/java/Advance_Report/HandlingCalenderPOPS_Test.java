package Advance_Report;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HandlingCalenderPOPS_Test {
	
	@Test
	
	public void ircts_Test() {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disabledNotification--");
		WebDriver driver =  new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']/input")).click();
		driver.findElement(By.xpath("//a[text()='30']")).click();
	}
}
