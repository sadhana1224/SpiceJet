package com.spicejet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;

public class SpicejetLoginPage extends SeWrappers {
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement login;
	
	@FindBy(xpath="//input[@data-testid='user-mobileno-input-box']")
	WebElement phNum;
	
	@FindBy(xpath="//input[@data-testid='password-input-box-cta']")
	WebElement pwd;
	
	@FindBy(xpath="//div[@data-testid='login-cta']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[text()='Hi sadhana']")
	WebElement visiblename;
	
	public void clickLogin()
	{
		if(click(login))
			Reports.reportStep("PASS","Login link clicked");
		else
			Reports.reportStep("FAIL","Login link not clicked");
	}
	public void setPhoneNum(String phonNum)
	{
		typeText(phNum,phonNum);
	}
	public void setPassword(String powd)
	{
		typeText(pwd,powd);
	}
	public void loginClick()
	{
		if(click(loginButton))
			Reports.reportStep("PASS","Login button clicked");
		else
			Reports.reportStep("FAIL","Login button not clicked");
	}
	public void visibleUsername()
	{
		waitForMe(visiblename, 20);
	}
	
	
	
	
}
