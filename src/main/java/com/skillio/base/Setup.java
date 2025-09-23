package com.skillio.base;

import org.testng.annotations.AfterMethod;
import com.skillio.utils.Environment;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Setup {

	@Before
	public void setup() {
		String browserName = System.getProperty("browser");
		if (browserName == null) {
			browserName = Environment.getBrowserName();
		}
		Keyword.openBrowser(browserName);
		String env = System.getProperty("env");
		if (env == null)
			env = "qa";
		String url = Environment.getAppUrl(env);
		Keyword.launchAppUrl(url);

	}

	@After
	public void tearDown() throws Exception {
		Keyword.quitBrowser();
	}
}
