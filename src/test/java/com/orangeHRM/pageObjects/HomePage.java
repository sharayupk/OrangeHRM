package com.orangeHRM.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.testCases.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminLink;
	@FindBy(id="menu_admin_UserManagement")
	WebElement userManagementLink;
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement usersLink;
	@FindBy(xpath="//*[@id='branding']//img")
	WebElement orangeHRMLogo;
	
	public boolean validateOrangeHRMLogo()
	{
		return orangeHRMLogo.isDisplayed();
	}
	
	public AddUserPage clickOnUsersLink()
	{
		adminLink.click();
		userManagementLink.click();
		usersLink.click();
		return new AddUserPage();
	}
	
	
	

}
