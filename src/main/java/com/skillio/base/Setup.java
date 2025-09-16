package com.skillio.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.skillio.utils.Environment;

public class Setup {
	
	
	@Parameters("browser-name")
	@BeforeMethod
	public void setup(@Optional String browserName) {

		if (browserName == null) {
			browserName = Environment.getBrowserName();
		}
		Keyword.openBrowser(browserName);
		String env = System.getProperty("env");
		String url = Environment.getAppUrl(env);
		Keyword.launchAppUrl(url);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Keyword.quitBrowser();
	}
}
