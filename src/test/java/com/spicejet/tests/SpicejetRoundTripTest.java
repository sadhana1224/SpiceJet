package com.spicejet.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;

public class SpicejetRoundTripTest  extends SeWrappers{
	SpiceWrappers sw= new SpiceWrappers();
	SeWrappers se= new SeWrappers();


	@Test
	
	public void SearchRoundTripFlight()
	{
		try
		{
			
			Reports.setTCDesc("Validating Search RoundTripFlight functionality ");
			sw.launchBrowser();
			sw.loginSpicejet("9688741481", "Sadhumaa@123");
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
	@AfterMethod
	public void closeBrowsers() throws InterruptedException
	{
		Thread.sleep(3000);
		closeAllBrowsers();
	}
}
