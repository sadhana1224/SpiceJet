package com.spicejet.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;

public class SpicejetLoginTest extends SeWrappers
{
	SpiceWrappers sw= new SpiceWrappers();
	SeWrappers se= new SeWrappers();

	@Test
	public void loginSpiceJet()
{
	try
	{
		Reports.setTCDesc("Validating login functionality with valid credentials");
		sw.launchBrowser();
		sw.loginSpicejet("9688741481", "Sadhumaa@123");
		Reports.setTCDesc("Searching OneWayFlight with valid credentials");
		sw.oneWayFlight(10);
	//	Reports.reportStep("PASS", "Login with valid credentials passed");
		
		screenshot("loginOneWay_valid");
	}
	catch(Exception ex)
	{
		Reports.reportStep("FAIL", "Login failed");
		ex.printStackTrace();
	}
}

	@AfterMethod
	public void closeBrowsers()
	{
		closeAllBrowsers();
	}
	
}
	

