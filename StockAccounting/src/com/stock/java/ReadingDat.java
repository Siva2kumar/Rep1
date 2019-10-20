package com.stock.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingDat {
	
	public static void main(String[] args) throws Throwable{
		Properties configProperties=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Sivakumar.y\\StockAccounting\\PropertiesFile\\Environment.properties");
		configProperties.load(fis);
		System.out.println(configProperties.getProperty("Browser"));
		System.out.println(configProperties.getProperty("url"));
		System.out.println(configProperties.getProperty("UserName"));
		System.out.println(configProperties.getProperty("Password"));
				
	}

}
