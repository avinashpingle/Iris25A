package com.skillio.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class can be used to read data from property files.
 */
public class PropUtil {

	public static String readProperty(String filePath, String key) {
		FileInputStream fis = null;
		String value = null;
		try {
			fis = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}
}
