package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilityPOM {
	
	public class WebDriverUtility {
		private WebDriver driver;
		private String parentWin;

		public void launchBowsr(String b) {
			if (b.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (b.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (b.equals("edge")) {
				driver = new EdgeDriver();
			} else {
				driver = new ChromeDriver();
			}
		}

		public WebDriverUtility(WebDriver driver) {
			this.driver = driver;
			String parentWin = driver.getWindowHandle();
			this.parentWin = parentWin;
		}

		public void waitForPageToLoad(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		}

		public void waitForElementToLoad(WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		public void switchToTabOnURL(String partialURL) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();

			while (it.hasNext()) {
				String windowID = it.next();
				driver.switchTo().window(windowID);
				String actUrl = driver.getCurrentUrl();
				if (actUrl.contains(partialURL)) {
					break;

				}
			}
		}

		public void switchToWin() {
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for (String win : allWindows) {
				if (!win.equals(parentWindow)) {
					driver.switchTo().window(win);
					break;
				}
			}
		}

		public void switchToParentWindow() {
			driver.switchTo().window(parentWin);
		}

		public void switchToTabOnTitle(String partialTitle) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();

			while (it.hasNext()) {
				String windowID = it.next();
				driver.switchTo().window(windowID);

				String actUrl = driver.getTitle();

				if (actUrl.contains(partialTitle)) {
					break;

				}
			}
		}

		// Below method is overloaded method:
		public void switchtoFrame(int index) {
			driver.switchTo().frame(index);
		}

		public void switchtoFrame(WebDriver driver, String nameID) {
			driver.switchTo().frame(nameID);
		}

		public void switchtoFrame(WebDriver driver, WebElement element) {
			driver.switchTo().frame(element);
		}

		// Switch method is alert method:
		public void switchtoAlertAndAccept() {
			driver.switchTo().alert().accept();
		}

		public void switchtoAlertAndCancel(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}

		// Select class Method:
		public void WebElementDropDown(WebElement element, int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}

		public void WebElementDropDown(WebElement element, String text) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}

		// Action class method:
		public void mouseMoveToElement(WebElement element) {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}

		public void DoubleClick(WebElement element) {
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		}
	}

	
	
}
