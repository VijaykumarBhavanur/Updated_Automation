package com.selenium.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver localDriver;
	public LoginPage(WebDriver remoteDriver) {
		localDriver=remoteDriver;
		PageFactory.initElements(remoteDriver,this);
	}
	
	@FindBy(id = "mat-input-0")
	WebElement txtUserName;
	
	@FindBy(id = "mat-input-1")
	WebElement txtPassword;
	
	@FindBy(xpath ="//button[@class='login-button mat-button']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//img[@class='avatar']")
	WebElement btnLogout;
	
	@FindBy(xpath = "//button[@class='mat-button cancel-button unselected']")
	WebElement yesButton;
	
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}
	
	public void yesButtonClick()
	{
		yesButton.click();
	}
}
