package com.skillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.base.Locator;
import com.skillio.utils.WaitFor;

/**
 * This class represents the Home Page of myntra.com
 */
public class HomePage {
	
	public HomePage() {
		PageFactory.initElements(Keyword.driver, this);
		
	}
	
	@FindBy(css = "div.desktop-query input.desktop-searchBar")
	public WebElement searchProductsTxtBx;
	
	
	public void enterProductNameToSearch(String productName) {
		searchProductsTxtBx.sendKeys(productName+Keys.ENTER);
		System.out.println("Searching "+productName+" on home page");
		WaitFor.presenceOfElement(By.cssSelector(Locator.productCard));
	}
	
	
}
