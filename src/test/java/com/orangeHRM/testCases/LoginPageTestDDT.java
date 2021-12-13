package com.orangeHRM.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangeHRM.pageObjects.HomePage;
import com.orangeHRM.pageObjects.LoginPage;
import com.orangeHRM.utilities.XLUtils;

public class LoginPageTestDDT extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTestDDT()
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
	
	@Test(dataProvider="loginTest")
	public void loginTest(String un,String pwd) throws InterruptedException, Exception
	{
		loginPage=new LoginPage();
		homePage=loginPage.login(un,pwd);
		logger.info("Login Done Successfully");	
		
	}	
	
	@DataProvider(name="loginTest")
	Object[][] getData() throws Exception
	{   
		String excelPath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\orangeHRM\\testData\\orangeHRMData.xlsx";
		int rowCount=XLUtils.getRowCount(excelPath, "Sheet1");
		int colCount=XLUtils.getCellCount(excelPath, "Sheet1", 1);
		
		String loginData[][]=new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(excelPath, "Sheet1", i, j);
			}
		}
		return loginData;
	}
	
	


}
