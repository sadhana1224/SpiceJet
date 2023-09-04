package com.spicejet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.spicejet.utils.SeWrappers;

public class SpicejetBookingPage extends SeWrappers {
	
	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']")
	WebElement payment;
	
	//passengers page
	//contact details
	@FindBy(xpath="//*[@data-testid='title-contact-detail-card']")
	WebElement details;
	@FindBy(xpath="//*[contains(text(),'Mrs')]")
	WebElement chooseMrs;
	@FindBy(xpath="//*[@data-testid='first-inputbox-contact-details']")
	WebElement fname;
	@FindBy(xpath="//*[@data-testid='last-inputbox-contact-details']")
	WebElement lname;
	@FindBy(xpath="//*[@data-testid='contact-number-input-box']")
	WebElement cnum;
	@FindBy(xpath="//*[@data-testid='emailAddress-inputbox-contact-details']")
	WebElement email;
	@FindBy(xpath="//*[@data-testid='city-inputbox-contact-details']")
	WebElement city;
	//1st passenger
	@FindBy(xpath="//*[@data-testid='traveller-0-title-field']")
	WebElement pas;
	@FindBy(xpath="(//*[contains(text(),'Mrs')])[2]")
	WebElement mrs;
	@FindBy(xpath="//input[@data-testid='traveller-0-first-traveller-info-input-box']")
	WebElement pname;
	@FindBy(xpath="//input[@data-testid='traveller-0-last-traveller-info-input-box']")
	WebElement plname;
	@FindBy(xpath="//input[@data-testid='sc-member-mobile-number-input-box']")
	WebElement plPhname;
	@FindBy(xpath="//div[@data-testid='traveller-0-travel-info-cta']")
	WebElement next;
	//2nd passenger
	@FindBy(xpath="//*[@data-testid='traveller-1-first-traveller-info-input-box']")
	WebElement sname;
	@FindBy(xpath="//*[@data-testid='traveller-1-last-traveller-info-input-box']")
	WebElement slname;
	@FindBy(xpath="//*[@data-testid='sc-member-mobile-number-input-box']")
	WebElement sphnum;
	//continue to add-ons
	@FindBy(xpath="//div[@data-testid='traveller-info-continue-cta']")
	WebElement adsClick;
	
	//dummy payment
	@FindBy(xpath="//input[@id='card_number']")
	WebElement cardnumber;	
	@FindBy(xpath="//input[@id='name_on_card']")
	WebElement cardname;
	@FindBy(xpath="//input[@id='card_exp_month']")
	WebElement expirymonth;
	@FindBy(xpath="//input[@id='card_exp_year']")
	WebElement expiryYear;
	@FindBy(xpath="//input[@id='security_code']")
	WebElement cvvNum;
	//proceed to pay
	@FindBy(xpath="//div[text()='Proceed to pay']")
	WebElement payButton;
	public void BookingFlights()
	{
		actionClick(payment);
		click(details);
		click(chooseMrs);
	}
	public void details (String cname,String clastname,String conNum,String emailA,String cityy)
	{
		typeText(fname,cname);
		typeText(lname,clastname);
		typeText(cnum,conNum);
		typeText(email,emailA);
		typeText(city,cityy);
	}
	public void  passenger1(String pasname,String pasLast,String pasNum)
	{
		click(pas);
		click(mrs);
		typeText(pname, pasname);
		typeText(plname, pasLast);
		typeText(plPhname, pasNum);
		click(next);	
	}
	public void passenger2(String seName,String selastName,String sePhonnum)
	{
		typeText(sname,seName);
		typeText(slname,selastName);
		typeText(sphnum,sePhonnum);
		click(adsClick);
		waitForMe(adsClick,10);		
	}
	
	public void dummyPayment(String cnum,String cname,String mon,String yr,String cvv)
	{
		typeText(cardnumber,cnum);
		typeText(cardname,cname);
		typeText(expirymonth,mon);
		typeText(expiryYear,yr);
		typeText(cvvNum,cvv);
		click(payButton);
	}
	}


