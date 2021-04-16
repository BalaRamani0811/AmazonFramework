package com.mindtree.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyRead {

	public String getPropertyData(String string) throws Exception {
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("C:\\TestNGSelenium\\AmazonFramework\\Configure.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		string = prop.getProperty(string);
		return string;
	}
	
}
