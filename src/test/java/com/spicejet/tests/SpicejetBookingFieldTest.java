package com.spicejet.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;

public class SpicejetBookingFieldTest extends SeWrappers{
	SpiceWrappers sw= new SpiceWrappers();
	SeWrappers se= new SeWrappers();
	
	@Test	
	public void validateBookingField()
	{
		try
		{
			Reports.setTCDesc("Validating BookingFields functionality ");
			sw.launchBrowser();
			sw.loginSpicejet("9688741481", "Sadhumaa@123");
			sw.validateBookingField();
			screenshot("BookingField");
		
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL", "validating Booking failed");
			ex.printStackTrace();
		}
	}
	@AfterMethod
	public void closeBrowsers()
	{
		closeAllBrowsers();
	}
}
