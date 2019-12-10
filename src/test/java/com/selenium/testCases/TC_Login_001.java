package com.selenium.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.PageObject.LoginPage;

public class TC_Login_001 extends BaseClass{
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		
		
		logger.info("URL Opened");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("Username entered");
		loginPage.setPassword(password);
		logger.info("Password entered");
		loginPage.clickLogin();
		Thread.sleep(2000);
		
		if(driver.getTitle().equals("fundooPush Admin"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
}
