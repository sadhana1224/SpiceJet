package com.spicejet.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;

public class SpicejetOneWayTest extends SeWrappers{
	SpiceWrappers sw= new SpiceWrappers();
	SeWrappers se= new SeWrappers();
	@BeforeMethod
	
	public void launchBrowser()
	{
		sw.launchBrowser();
		sw.loginSpicejet("9688741481", "Sadhumaa@123");
	}
	@Test
	
	public void SearchOneWayFlight()
	{
		try
		{
		
			Reports.setTCDesc("Validating Search Flight functionality ");
			sw.oneWayFlight(20);
			Reports.reportStep("PASS", "Search with valid credentials passed");
			Thread.sleep(2000);
			screenshot("OneWay_valid");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL", "Search OneWay Flights failed");
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
