package com.skillio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.skillio.base.Keyword;
import com.skillio.base.Locator;
import com.skillio.base.Setup;
import com.skillio.pages.HomePage;
import com.skillio.pages.PRPPage;
import com.skillio.utils.WaitFor;

public class MyTestCases extends Setup{
	
	@Test(description = "TC001-Verfiy jeans filter on SRP")
	public void verfiyJeansFilterOnSRP() throws InterruptedException {
		/*
		driver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]")).sendKeys("Levis",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class=\"categories-list\"]/li[1]")).click();
		Thread.sleep(2000);
		
		List<WebElement> productTitles = driver.findElements(By.xpath("//h4[@class=\"product-product\"]"));
		
		for (WebElement productTitle : productTitles) {
			String productTitleText = productTitle.getText();
			Assert.assertTrue(productTitleText.contains("Jeans"),"Product other than jeans: "+productTitleText); //True: Pass false: Fail
			
		}
		*/
	}
	
	@Test
	public void verfiyJeansFilterOnSRPUsingKeyword() {
		Keyword.enterText("xpath", Locator.searchProductsTextBx, "Levis",Keys.ENTER);
		WaitFor.presenceOfElement(By.cssSelector(Locator.productCard));
		Keyword.clickOn("css", Locator.jeansFilter);
		WaitFor.elementToBeClickable(By.cssSelector(Locator.selectedFilter));
		List<String> productTitles = Keyword.getTexts("css", "h4.product-product");
		
		for (String productTitle : productTitles) {
			Assert.assertTrue(productTitle.contains("Jeans"),"Product other than jeans: "+productTitle);
		}
	}
	
	@Test
	public void verfiyJeansFilterOnSRPUsingPom() {
		HomePage homepage = new HomePage();
		homepage.enterProductNameToSearch("Levis");
		PRPPage prp = new PRPPage();
		prp.clikcOnJeansFilter();
		prp.assertAllProductTitlesContains("Jeans");
	}
	
}




















