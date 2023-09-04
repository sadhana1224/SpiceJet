package com.spicejet.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;

public class SpicejetLogin_NegativeTest extends SeWrappers
{
	SpiceWrappers sw= new SpiceWrappers();
	SeWrappers se= new SeWrappers();
	//negative test case
	@Test	
		public void loginInvalidCred()
		{
			try
			{
				Reports.setTCDesc("Validating login functionality with invalid credentials");
				sw.launchBrowser("https://www.spicejet.com/");
				sw.login_invalidCredentials("9689523565", "Sadhumaa@123456");	
				screenshot("login_invalid");
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
