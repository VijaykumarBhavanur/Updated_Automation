package com.selenium.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddStory {
	WebDriver localDriver;

	public AddStory(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);

	}

	@FindBy(xpath ="//mat-icon[@class='mat-icon-floating mat-icon material-icons notranslate mat-icon-no-color']")
	WebElement addCTA;
	
	
	@FindBy(xpath ="//button[contains(text(),'ADD STORY')]")
	WebElement addStory;
	
	
	@FindBy(xpath = "//textarea[@id='mat-input-3']")
	WebElement infoURL;
	
	
	@FindBy(xpath = "//span[contains(text(),'Post')]")
	WebElement postButton;
	
	public void clickaddCTA()
	{
		addCTA.click();
	}
	
	public void clickaddStory()
	{
		addStory.click();
	}
	
	public void setURL(String url)
	{
		infoURL.sendKeys(url,Keys.TAB);
	}
	
	public void clickpostButton()
	{
		postButton.click();
	}
	
}
