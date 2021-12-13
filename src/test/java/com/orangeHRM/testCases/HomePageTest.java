package com.orangeHRM.testCases;

import org.testng.annotations.Test;

import com.orangeHRM.pageObjects.AddUserPage;
import com.orangeHRM.pageObjects.HomePage;
import com.orangeHRM.pageObjects.LoginPage;

public class HomePageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	AddUserPage addUserPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@Test(priority=1)
	public void loginTest()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("Login Done Successfully");		
	}
	
	@Test(priority=2)
	public void clickOnUsersLinkTest()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("Login Done Successfully");	
		
		addUserPage=homePage.clickOnUsersLink();
		logger.info("Clicked on Users Link");
	}

}
