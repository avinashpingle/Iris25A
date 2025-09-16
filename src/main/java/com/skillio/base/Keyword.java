package com.skillio.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.skillio.errors.InvalidBrowserNameError;
import com.skillio.exceptions.InvalidLocatorException;
import com.skillio.utils.WaitFor;

public class Keyword {
	public static RemoteWebDriver driver;

	public static void openBrowser(String browserName) {
		if (browserName == null) {
			System.out.println("Launching default browser: Firefox");
			browserName = "Firefox";
		}

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			throw new InvalidBrowserNameError(browserName);
		}
	}

	public static void launchAppUrl(String url) {
		driver.get(url);
	}

	public static void enterText(String locatorType, String locator, CharSequence... text) {
		getWebElement(locatorType, locator).sendKeys(text);
	}

	public static void clickOn(String locatorType, String locator) {
		getWebElement(locatorType, locator).click();
	}

	private static WebElement getWebElement(String locatorType, String locator) {
		WebElement element;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locator));
		} else if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locator));
		} else if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locator));
		} else {
			throw new InvalidLocatorException(locatorType);
		}

		return element;
	}

	public String getText(String locatorType, String locator) {
		return getWebElement(locatorType, locator).getText();
	}

	public static List<String> getTexts(String locatorType, String locator) {
		List<WebElement> elements = getWebElements(locatorType, locator);
		List<String> elementTexts = new ArrayList<String>();
		for (WebElement element : elements) {
			try {
				elementTexts.add(element.getText());
				//elements.remove(element);
			} catch (StaleElementReferenceException e) {
				while(!WaitFor.stalenessOfElement(element)) {
					elementTexts.add(element.getText());
					break;
				}
				
				//elements.remove(element);				
			}
		}
		return elementTexts;
	}

	private static List<WebElement> getWebElements(String locatorType, String locator) {
		List<WebElement> elements;
		if (locatorType.equalsIgnoreCase("xpath")) {
			elements = driver.findElements(By.xpath(locator));
		} else if (locatorType.equalsIgnoreCase("css")) {
			elements = driver.findElements(By.cssSelector(locator));
		} else if (locatorType.equalsIgnoreCase("id")) {
			elements = driver.findElements(By.id(locator));
		} else {
			throw new InvalidLocatorException(locatorType);
		}

		return elements;
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void clickOn(By addToBagBtn) {
		driver.findElement(addToBagBtn).click();
	}

}
