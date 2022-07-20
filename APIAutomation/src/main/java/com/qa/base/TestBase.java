package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public int RESPONSE_STATUS_CODE=200;
	public Properties prop;
	
	public TestBase() throws IOException {
		prop= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\paull\\eclipse-workspace\\APIAutomation\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(fis);
		System.out.println(prop.get("URL"));
		System.out.println(prop.get("ServiceUrl"));
		
		
	}
	

}
