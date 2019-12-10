package com.selenium.testCases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selenium.PageObject.LoginPage;
import com.selenium.model.Login;
import com.selenium.utilities.XLUtils;

public class LoginDDT_001 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String username,String password) throws InterruptedException
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("UserName entered:::::");
		loginPage.setPassword(password);
		logger.info("Password entered:::::");
		loginPage.clickLogin();
		logger.info("Login button clicked:::::");
		
		Thread.sleep(3000);
		if(driver.getPageSource().contains("fundooPush Admin"))
		{
			assertTrue(true);
			loginPage.clickLogout();
			loginPage.yesButtonClick();
			//driver.switchTo().defaultContent();
			Thread.sleep(3000);
		}
		else
		{
			assertTrue(false);
		}
		
	}
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException
	{
		String path="/home/admin1/Downloads/LoginData.xlsx";
		
		int row_count=XLUtils.getRowCount(path,"Sheet1");
		XLUtils util=new XLUtils();
		
		
		int row_count1=util.getLastRowWithData();
		System.out.println("Number of rows actually containing data:::::"+row_count1);
		
		
		System.out.println("Number of rows:::::::"+row_count);
		int col_count=XLUtils.getCellCount(path, "Sheet1",1);
		
		System.out.println("Number of columns:::::::"+col_count);
		String login_data[][]=new String[row_count1][col_count];
		
		for (int i = 1; i <=row_count1; i++) 
		{
			for (int j = 0; j <col_count; j++)
			{
				login_data[i-1][j]=XLUtils.getCellData(path, "Sheet1",i,j);
				System.out.println("Content stored:::::::"+login_data[i-1][j]);
				System.out.println("Scanning "+i+" row and "+j+" column\n\n\n");
			}
			System.out.println("Scanning:::"+i+" row \n\n\n");
		}
		
		return login_data;
	}
	
	
			/*To read data from JSON file*/
	/*
	 * @DataProvider(name = "LoginData1") String[][] getData1() throws IOException {
	 * File file=new File("/home/admin1/Desktop/login.json"); ObjectMapper mapper =
	 * new ObjectMapper(); List<Login> credentials= new
	 * ArrayList<Login>(Arrays.asList(mapper.readValue(file, Login[].class)));
	 * 
	 * int index=0; String[][] login_data=new String[2][2];
	 * 
	 * return login_data; }
	 */
	
}
