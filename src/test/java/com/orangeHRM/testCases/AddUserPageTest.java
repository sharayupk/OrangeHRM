package com.orangeHRM.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.orangeHRM.pageObjects.AddUserPage;
import com.orangeHRM.pageObjects.HomePage;
import com.orangeHRM.pageObjects.LoginPage;

public class AddUserPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	AddUserPage addUserPage;
	
	public AddUserPageTest()
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
	
	@Test(priority=3)
	public void clickOnAddBtnTest()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("Login Done Successfully");	
		
		addUserPage=homePage.clickOnUsersLink();
		logger.info("Clicked on Users Link");
		
		addUserPage.clickOnAddBtn();
		logger.info("Clicked on Add Button on Users Page");
	}
	
	@Test(priority=4)
	public void addUserDetailsTest()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("Login Done Successfully");	
		
		addUserPage=homePage.clickOnUsersLink();
		logger.info("Clicked on Users Link");
		
		addUserPage.clickOnAddBtn();
		logger.info("Clicked on Add Button on Users Page");
		
		addUserPage.addUserDetails("Ankur", "Ankur", "Ankur@123", "Ankur@123");
		logger.info("User Added Successfully");
	}
	
	@Test(priority=5)
	public void getEnabledUsersListTest()
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("Login Done Successfully");	
		
		addUserPage=homePage.clickOnUsersLink();
		logger.info("Clicked on Users Link");
		
		//Get Total No. Rows
		int rows=driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr")).size();
		System.out.println("No. of Rows--->"+rows);
		
		int statusCount=0;
		
		for(int i=1;i<rows;i++)
		{
			String status=driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[5]")).getText();
			if(status.equals("Enabled"))
			{
				statusCount=statusCount+1;
			}
		}
		System.out.println("No Of Employees Enabled---->"+statusCount);
		logger.info("Enabled Users List is Displayed");
	}
	
	

}
