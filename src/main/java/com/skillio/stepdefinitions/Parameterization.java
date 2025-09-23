package com.skillio.stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.skillio.utils.ExcelUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Parameterization {

	int x, y,result=0, qty;
	String fruitName;
	String promocode;
	Map<String,Integer> fruits;
	
	@Given("I have two numbers {int} and {int}")
	public void acceptTwoNumbers(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@When("I add them")
	public void addNumbers() {
		result = x+y;
	}
	
	@Then("print the result")
	public void diplsayResult() {
		System.out.println("Result = "+result);
	}
	
	@Given("I have an {word}")
	public void acceptFruit(String fruitName) {
		this.fruitName = fruitName;
	}
	
	@When("I have its quantity as {int}")
	public void acceptQnty(int qty) {
		System.out.println("Quantity is "+qty);
	}
	
	@Then("print {string}")
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	@Given("I have following fruits:")
	public void acceptListOfFruits(Map<String,Integer> fruits) {
		this.fruits = fruits;
	}
	
	@Then("print the entire list")
	public void printListOfFruits() {
		for (Entry<String, Integer> fruitEntry : fruits.entrySet()) {
			System.err.println("I have "+fruitEntry.getValue()+" "+fruitEntry.getKey());
		}
	}
	
	@Given("I have a fruit {word}")
	public void iHaveAFruit(String fruitName) {
		this.fruitName = fruitName;
	}
	
	@Then("print the fruit name and its quantity")
	public void printFruitName() {
		System.err.println("I have "+qty+" "+this.fruitName);
	}
	
	@And("its quantity as {int}")
	public void acceptQty(int qty) {
		this.qty = qty;
	}
	
	@Given("I have a {int}")
	public void acceptPromoCodeFromExcel(int rowNum) {
		String baseDir = System.getProperty("user.dir");
		String filePath = "/src/test/resources/testdata/PromoCodes.xlsx";
		String promoCode = ExcelUtil.getCellFromRow(baseDir+filePath, rowNum, 1);
		this.promocode = promoCode;
	}
	
	@Then("print the promocode")
	public void printPromoCode() {
		System.err.println("Promo code is: "+promocode);
	}
}
