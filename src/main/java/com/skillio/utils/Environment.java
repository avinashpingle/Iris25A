package com.skillio.utils;

public class Environment {

	private static String baseDir = System.getProperty("user.dir");
	private static String filePath = "/src/main/resources/environment.properties";

	public static String getBrowserName() {
		return PropUtil.readProperty(baseDir + filePath, "browser_name");
	}

	public static String getAppUrl(String env) {//qa
		System.out.println("Launching test on "+env+" environment");
		return PropUtil.readProperty(baseDir+filePath, env + "_app_url");
	}
}
