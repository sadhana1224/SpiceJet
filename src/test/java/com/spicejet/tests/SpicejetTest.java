package com.spicejet.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;
import com.spicejet.utils.Reports;
import com.spicejet.utils.Reports;

public class SpicejetTest extends SeWrappers{
	SeWrappers se= new SeWrappers();
	SpiceWrappers sw=new SpiceWrappers();
	
	//First testcase
	@Test	
	public void browserLaunch()
	{
		try
		{
			Reports.startReport();
			Reports.setTCDesc("Valid launchbrowser functionality");
			launchBrowser();
				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Reports.reportStep("FAIL", "Problem in launchBrowser");
		}
	}
	
	@AfterMethod
	public void closeBrowsers()
	{
		closeAllBrowsers();
	}

}
