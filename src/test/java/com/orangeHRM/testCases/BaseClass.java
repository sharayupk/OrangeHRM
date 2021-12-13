package com.orangeHRM.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.orangeHRM.utilities.Utils;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	public static Logger logger;

	public BaseClass()
	{
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("./Configuration/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@BeforeMethod
	public void initialization()
	{
		String browserName=prop.getProperty("browser");
		
		logger=Logger.getLogger("OrangeHRM");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
			driver=new ChromeDriver();
			logger.info("Launching Chrome Browser");
		}
		
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette",prop.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
			logger.info("Launching Firefox Browser");
		}
		
		driver.get(prop.getProperty("url"));
		logger.info("Launching URL");
		
		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		logger.info("Closing Browser");
	}

}
