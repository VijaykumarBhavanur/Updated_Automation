package com.selenium.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.selenium.PageObject.AddStory;
import com.selenium.PageObject.LoginPage;

public class TC_AddStory_001 extends BaseClass{
	
	@Test
	public void addStory() throws InterruptedException
	{
		
		logger.info("URL Opened");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("Username entered");
		loginPage.setPassword(password);
		logger.info("Password entered");
		Thread.sleep(2000);
		loginPage.clickLogin();
		Thread.sleep(2000);
		
		AddStory addStory=new AddStory(driver);
		addStory.clickaddCTA();
		Thread.sleep(2000);
		addStory.clickaddStory();
		addStory.setURL("https://www.bbc.com/news/world-europe-50643323");
		Thread.sleep(10000);
		addStory.clickpostButton();
		
		System.out.println("Page  contains::::::::"+driver.getPageSource());
		if(driver.getPageSource().contains("France crippled by biggest national strike in years"))
			assertTrue(true);
		else
			assertTrue(false);
		Thread.sleep(5000);
		loginPage.clickLogout();
	}
}
