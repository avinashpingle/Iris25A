package com.skillio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;

/**
 * This is a page object class for Product
 * This page represent this url: https://www.myntra.com/lounge-tshirts/levis/levis-men-soft-pure-cotton-round-neck-half-sleeve-tshirt/12027432/buy
 */
public class PIPPage {
	@FindBy(xpath = "//button[@class='pdp-add-to-bag pdp-button pdp-flex pdp-center']")
	private WebElement pip_addToBagBtn;
	
	PIPPage() {
		PageFactory.initElements(Keyword.driver, this); //Lazy Proxy for all WebElements
	}
	
	public void clickOnAddToBagBtn() {
		pip_addToBagBtn.click();
	}
	
}
