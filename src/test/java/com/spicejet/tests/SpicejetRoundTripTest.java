package com.spicejet.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;

public class SpicejetRoundTripTest  extends SeWrappers{
	SpiceWrappers sw= new SpiceWrappers();
	SeWrappers se= new SeWrappers();

	@BeforeMethod
	public void launchBrowser()
	{
		sw.launchBrowser("https://www.spicejet.com/");
		sw.loginSpicejet("9688741481", "Sadhumaa@123");
	}
	@Test
	
	public void SearchRoundTripFlight()
	{
		try
		{
			
			Reports.setTCDesc("Validating Search RoundTripFlight functionality ");
			sw.RoundTripFlight(20,10);
			Reports.reportStep("PASS", "Search RoundTripFlight passed");
			Thread.sleep(2000);
		   screenshot("RoundTrip");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL", "Search RoundTripFlight failed");
			ex.printStackTrace();
		}
	}
	
}
