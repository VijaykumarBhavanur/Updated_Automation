package com.selenium.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties property;

	public ReadConfig() {
		File source = new File("./Configuration/config.properties");

		try {
			FileInputStream fin = new FileInputStream(source);
			property = new Properties();
			property.load(fin);
		} catch (Exception e) {
			System.out.println("Exception caught::::" + e.getMessage());
		}
	}
	
	public String getBaseURL()
	{
		String url=property.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String uname=property.getProperty("username");
		return uname;
	}
	
	public String getPassword()
	{
		String password=property.getProperty("password");
		return password;
	}
	
	public String getChromepath()
	{
		String chromepath=property.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxpath()
	{
		String firefoxpath=property.getProperty("firefoxpath");
		return firefoxpath;
	}
}
