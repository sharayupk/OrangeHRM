package com.orangeHRM.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.testCases.BaseClass;

public class AddUserPage extends BaseClass{
	
	public AddUserPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="btnAdd")
	WebElement addUserBtn;
	@FindBy(id="systemUser_employeeName_empName")
	WebElement employeeName;
	@FindBy(id="systemUser_userName")
	WebElement userName;
	@FindBy(id="systemUser_password")
	WebElement Password;
	@FindBy(id="systemUser_confirmPassword")
	WebElement conPassword;
	@FindBy(id="btnSave")
	WebElement saveBtn;
	
	public void clickOnAddBtn()
	{
		addUserBtn.click();
	}
	
	public void addUserDetails(String empName,String usName,String pwd,String conPwd)
	{
		employeeName.sendKeys(empName);
		userName.sendKeys(usName);
		Password.sendKeys(pwd);
		conPassword.sendKeys(conPwd);
		saveBtn.click();
	}
	
	

}
