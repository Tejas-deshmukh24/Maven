package Advance_Report;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingCalenderPOPS_Test2 {
	
	@Test
	public void goIbibo_test() {
		String MonthAndYear="September 25";
		String date = "23";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
/*		driver.get("");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@role='presentation")).click();
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"")).click();
			   break;
				catch(Exception e) {
					driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				}
			                  */
		}
	}


