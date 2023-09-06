package com.spicejet.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;

public class SpicejetInPassesgerDet_NegativePage extends SeWrappers {
	
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
	
	
	
	public void loginPage(String phonNum,String powd) throws InterruptedException
	{
		if(click(login))
			Reports.reportStep("PASS","Login link clicked");
		else
			Reports.reportStep("FAIL","Login link not clicked");
		
		typeText(phNum,phonNum);
		typeText(pwd,powd);
		
		if(click(loginButton))
			Reports.reportStep("PASS","Login button clicked");
		else
			Reports.reportStep("FAIL","Login button not clicked");
		
		if(waitForMe(visiblename, 20))
			Reports.reportStep("PASS","Login successfull");
			else
				Reports.reportStep("FAil","Login failed");
			
			Thread.sleep(5000);
	}
	
	
	
}
