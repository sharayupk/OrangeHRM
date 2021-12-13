package com.orangeHRM.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.pageObjects.HomePage;
import com.orangeHRM.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@Test(priority=1)
	public void validateorangeHRMLogoTest()
	{
		loginPage=new LoginPage();
		boolean result=loginPage.validateOrangeHRMLogo();
		Assert.assertTrue(result);
		logger.info("Validating Login Page OrangeHRMLogo");
	}
	
	@Test(priority=2)
	public void validateLoginPageTitleTest()
	{
		loginPage=new LoginPage();
		String actTitle=loginPage.validateLoginPageTitle();
		Assert.assertEquals(actTitle, "OrangeHRM");
		logger.info("Validating Login Page Title");
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("Login Done Successfully");		
	}

}
