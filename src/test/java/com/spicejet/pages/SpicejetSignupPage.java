package com.spicejet.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spicejet.utils.SeWrappers;

public class SpicejetSignupPage extends SeWrappers{

	@FindBy(xpath="//div[contains(text(),'Signup')]")
	WebElement clickSignup;
	
	@FindBy(xpath="//select[@class='form-control form-select ']")
	WebElement choose;
	
	@FindBy(xpath="//input[@id='first_name' and @class='form-control ']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='last_name' and @class='form-control ']")
	WebElement lname;
	
	@FindBy(xpath="//select[@class='form-control form-select']")
	WebElement country;
	
	@FindBy(xpath="//img[@class='d-inline-block datepicker']")
	WebElement clickDatePic;
	
	@FindBy(xpath="//div[@class='react-datepicker__month-container']")
	WebElement dateContainer;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']//option[text()='July']")
	WebElement month;

	@FindBy(xpath="//select[@class='react-datepicker__year-select']//option[text()='1997']")
	WebElement year;

	@FindBy(xpath="//div[text()='7']")
	WebElement day;
	
	@FindBy(xpath="//input[@class=' form-control']")
	WebElement phnum;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement clp;
	@FindBy(xpath="//input[@id='email_id']")
	WebElement email;
	@FindBy(xpath="//input[@id='new-password']")
	WebElement pwd;
	@FindBy(xpath="//input[@id='c-password']")
	WebElement repwd;
	
	@FindBy(xpath="(//a//button)[3]")
	WebElement sub;
	
	SeWrappers se= new SeWrappers();
	public void signUpClick(String firstname,String lastname,String coun,String pnum,String emailid,String pswd,String repass) throws InterruptedException
	{
		click(clickSignup);
		switchWindows();
		selectByIndex(choose, 2);
		
		waitForMe(name,20);
		typeText(name, firstname);
		typeText(lname, lastname);
		
		typeText(country, coun);
		click(clickDatePic);
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(dateContainer));
		//waitForMe(dateContainer,20);
		click(month);
		click(year);
		click(day);
		jsVerticalScroll(500);
		typeText(phnum, pnum);
		click(clp);
		click(email);
		
		typeText(email, emailid);
		
		click(email);
		
		//waitForMe(pwd,30);
		typeText(pwd, pswd);
		
		waitForMe(repwd,20);
		typeText(repwd, repass);
		
		jsClick(sub);
		
		Thread.sleep(8000);
		
	
	}
	
	
	

	
	
}
