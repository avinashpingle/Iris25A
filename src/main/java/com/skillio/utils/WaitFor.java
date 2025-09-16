package com.skillio.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillio.base.Keyword;

public class WaitFor {

	static WebDriverWait wait;
	
	static{
		wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);
		wait.withMessage("Script time out");
	}
	
	public static void presenceOfElement(By element) {
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	
	public static void elementToBeClickable(By element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static boolean stalenessOfElement(WebElement element) {
		return wait.until(ExpectedConditions.stalenessOf(element));
	}
	
}
