package com.orangeHRM.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.testCases.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="txtUsername")
	WebElement Username;
	@FindBy(id="txtPassword")
	WebElement Password;
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	@FindBy(xpath="//*[@id='divLogo']//img")
	WebElement orangeHRMLogo;

	public boolean validateOrangeHRMLogo()
	{
		return orangeHRMLogo.isDisplayed();
	}

	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}

	public HomePage login(String un,String pwd)
	{
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}



}
