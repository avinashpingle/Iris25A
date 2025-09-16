package com.skillio.stepdefinitions;

import com.skillio.base.Keyword;
import com.skillio.pages.HomePage;
import com.skillio.pages.PRPPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	@Given("browser is opened and myntra url is launched")
	public void launchBrowserAndUrl() {
		Keyword.openBrowser("Firefox");
		Keyword.launchAppUrl("https://www.myntra.com/");
	}
	
	@When("यूजर लेविस की जीन्स सर्च करेगा")
	public void searchProduct() {
		HomePage homepage = new HomePage();
		homepage.enterProductNameToSearch("Levis");
	}
	
	@And("user applied Jeans filter on Search Result Page")
	public void applyFilter() {
		PRPPage prp = new PRPPage();
		prp.clikcOnJeansFilter();
	}
	
	@Then("all results related to jeans should appear")
	public void verifyAllSearchResults() {
		PRPPage prp = new PRPPage();
		prp.assertAllProductTitlesContains("Jeans");
	}
}
