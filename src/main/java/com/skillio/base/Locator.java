package com.skillio.base;

public interface Locator {

	String searchProductsTextBx = "//input[@placeholder=\"Search for products, brands and more\"]";
	String productCard = "div#desktopSearchResults  li:nth-child(1) a";
	String jeansFilter = "ul.categories-list li:nth-child(1)";
	String productTitles = "h4.product-product";
	String selectedFilter = "div[class*='selectedFilterContainer']";
	
}
