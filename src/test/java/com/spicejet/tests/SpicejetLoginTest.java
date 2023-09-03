package com.spicejet.tests;

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
		sw.launchBrowser("https://www.spicejet.com/");
		sw.loginSpicejet("9688741481", "Sadhumaa@123");
		Reports.reportStep("PASS", "Login with valid credentials passed");
		
		screenshot("login_valid");
	}
	catch(Exception ex)
	{
		Reports.reportStep("FAIL", "Login failed");
		ex.printStackTrace();
	}

}
}
