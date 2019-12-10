package com.selenium.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.selenium.utilities.ReadConfig;

public class BaseClass {
	ReadConfig config = new ReadConfig();
	public String baseURL = config.getBaseURL();
	public String username = config.getUsername();
	public String password = config.getPassword();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String brow) {
		if (brow.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", config.getChromepath());
			driver = new ChromeDriver();
		} else if (brow.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", config.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		logger = Logger.getLogger("Framework_Implementation");
		PropertyConfigurator.configure("log4j.properties");
		// BasicConfigurator.configure();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
}
