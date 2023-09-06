package com.spicejet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;

public class SpicejetLogin_NegativePage extends SeWrappers {
	//negative testcase-1
	@FindBy(xpath="//div[text()='Login']")
	WebElement login;
	
	@FindBy(xpath="//input[@data-testid='user-mobileno-input-box']")
	WebElement phNum;
	
	@FindBy(xpath="//input[@data-testid='password-input-box-cta']")
	WebElement pwd;
	
	@FindBy(xpath="//div[@data-testid='login-cta']")
	WebElement loginButton;
	
	//negative testcase 2---empty field password
	@FindBy(xpath="//div[text()='Login']")
	WebElement login1;
	
	@FindBy(xpath="//input[@data-testid='user-mobileno-input-box']")
	WebElement phNum1;
	
	@FindBy(xpath="//input[@data-testid='password-input-box-cta']")
	WebElement pwd1;
	
	@FindBy(xpath="//div[@data-testid='login-cta']")
	WebElement loginButton1;
	
	@FindBy(xpath="//div[contains(text(),'Please enter a valid password')]")
	WebElement errormsg;
	
	public void login_invalidCredentials(String pnum,String pswd) throws InterruptedException
	{
		
		click(login);
		typeText(phNum,pnum);
		typeText(pwd,pswd);
		click(loginButton);
		Thread.sleep(3000);
		
	}
	public void login_emptyFieldPassword(String pnum1,String pswd1) throws InterruptedException
	{
		navigateRefresh();
		click(login1);
		typeText(phNum1,pnum1);
		typeText(pwd1,pswd1);
		if(click(loginButton1))
			Reports.reportStep("PASS","login button clicked");
		else 
			
			Reports.reportStep("FAIL","Problem in login in button");
		
		
		if(errormsg.isDisplayed())
			 Reports.reportStep("PASS", "Login with valid userName and empty field Password passed");
        else 
            Reports.reportStep("FAIL", "Login was successful, but it was expected to fail");
		
		Thread.sleep(3000);


	}

}
