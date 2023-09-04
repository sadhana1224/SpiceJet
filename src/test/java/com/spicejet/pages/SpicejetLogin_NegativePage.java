package com.spicejet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.spicejet.utils.SeWrappers;

public class SpicejetLogin_NegativePage extends SeWrappers {
	@FindBy(xpath="//div[text()='Login']")
	WebElement login;
	
	@FindBy(xpath="//input[@data-testid='user-mobileno-input-box']")
	WebElement phNum;
	
	@FindBy(xpath="//input[@data-testid='password-input-box-cta']")
	WebElement pwd;
	
	@FindBy(xpath="//div[@data-testid='login-cta']")
	WebElement loginButton;
	
	public void login_invalidCredentials(String pnum,String pswd) throws InterruptedException
	{
		
		click(login);
		typeText(phNum,pnum);
		typeText(pwd,pswd);
		click(loginButton);
		Thread.sleep(3000);
	}

}
