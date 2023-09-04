package com.spicejet.utils;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.spicejet.pages.SpicejetLoginPage;
import com.spicejet.pages.SpicejetLogin_NegativePage;
import com.spicejet.pages.SpicejetSignupPage;
import com.spicejet.pages.SearchFlightOneWay_Page;
import com.spicejet.pages.SearchFlightTwoWay_page;
import com.spicejet.pages.SpicejetBookingFieldPage;
import com.spicejet.pages.SpicejetBookingPage;




public class SpiceWrappers extends SeWrappers{
	SeWrappers se= new SeWrappers();

	public void signupSpicejet(String fname,String lname,String count,String phnum,String emailid,String pwd,String repwd) throws InterruptedException
	{
		SpicejetSignupPage sPage=PageFactory.initElements(driver, SpicejetSignupPage.class);
		sPage.signUpClick(fname, lname, count,phnum,emailid,pwd,repwd);
		
	}
	//Second Testcase
	public void loginSpicejet(String phnum,String pwd)
	{
    try
    {
    	SpicejetLoginPage lpPage=PageFactory.initElements(driver, SpicejetLoginPage.class);
    	lpPage.clickLogin();
    	lpPage.setPhoneNum(phnum);
    	lpPage.setPassword(pwd);
    	lpPage.loginClick();
    	lpPage.visibleUsername();
        	
    	
    }
    catch(Exception ex)
    {
    	ex.printStackTrace();
    }
	}
//oneway flight	
	public void oneWayFlight(int futuredate)
	{
		try
		{
			SearchFlightOneWay_Page sfPage=PageFactory.initElements(driver, SearchFlightOneWay_Page.class);
		
		   // sfPage.clickOneway();
			sfPage.clickOrigin();
			//sfPage.clickDeparture();
			//sfPage.clickOrigin1();
			//sfPage.clickDestination();
			sfPage.Choosedate(futuredate);
			sfPage.ChooseTravellers();
			sfPage.ChooseAdults();
			//sfPage.chooseChilds();
			//sfPage.chooseInfants();
			sfPage.clickCurrency();
			sfPage.chooseCurrency();
			sfPage.searchFlights();
		}
		 catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	}
	public void RoundTripFlight(int futureday,int futureday1)
	{
		try
		{
			SearchFlightTwoWay_page sftPage=PageFactory.initElements(driver, SearchFlightTwoWay_page.class);

			sftPage.roundTrip();
			sftPage.Choosedate(futureday);
		
			sftPage.flights();
			
		}
		 catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	}
	public void bookingFlights(String fname1,String lname1,String cnum1,String email1,String city1,String pasname,String paslname,String pasNum,String sename,String selaname,String seNum)
	{
		try
		{
			SpicejetBookingPage sbPage=PageFactory.initElements(driver, SpicejetBookingPage.class);
			sbPage.BookingFlights();
			//sbPage.details(fname1, lname1, cnum1, email1, city1);
			sbPage.passenger1(pasname, paslname, pasNum);
			sbPage.passenger2(sename, selaname, seNum);
			
		}
		 catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	}
	public void dummyPayment(String cnum,String cname,String mon,String yr,String cvv)
	{
		try
		{
			SpicejetBookingPage sbPage1=PageFactory.initElements(driver, SpicejetBookingPage.class);
			sbPage1.dummyPayment(cnum, cname, mon, yr, cvv);
		}
		catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	}
	public void validateBookingField() throws InterruptedException
	{
		
		SpicejetBookingFieldPage sbfPage=PageFactory.initElements(driver, SpicejetBookingFieldPage.class);
		sbfPage.bookingFields();

	}
	
	//negative testcase
	public void login_invalidCredentials(String phnum,String pwd) throws InterruptedException
	{
		SpicejetLogin_NegativePage snPage=PageFactory.initElements(driver, SpicejetLogin_NegativePage.class);
		snPage.login_invalidCredentials(phnum,pwd);
	}

}
