package com.skillio.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.skillio.base.Keyword;
import com.skillio.base.Locator;
import com.skillio.utils.WaitFor;

public class PRPPage {

	public PRPPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	@FindBy(css = "ul.categories-list>li:nth-child(1) label")
	public WebElement jeansFilter;

	@FindBy(css = "h4.product-product")
	public List<WebElement> productTitles;

	public void clikcOnJeansFilter() {
		jeansFilter.click();
		System.out.println("Clicked on Jeans Filter");
		WaitFor.elementToBeClickable(By.cssSelector(Locator.selectedFilter));
	}

	public List<String> getAllProductTitles() {
		List<String> productTexts = new ArrayList<String>();
		for (WebElement productTitle : productTitles) {
			productTexts.add(productTitle.getText());
		}
		return productTexts;
	}

	public void assertAllProductTitlesContains(String title) {
		SoftAssert softly = new SoftAssert();

		for (String productTitle : getAllProductTitles()) {
			softly.assertTrue(productTitle.contains(title), productTitle);
		}

		softly.assertAll();
	}
}
