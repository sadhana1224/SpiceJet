package com.spicejet.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;

public class SpicejetBookingTest extends SeWrappers{
	SpiceWrappers sw= new SpiceWrappers();
	SeWrappers se= new SeWrappers();
	
	
@Test	
	public void BookingFlight()
	{
		try
		{
			
			Reports.setTCDesc("Validating Booking Flight functionality ");
			sw.launchBrowser();
			sw.loginSpicejet("9688741481", "Sadhumaa@123");
			sw.oneWayFlight(20);
			sw.bookingFlights("Sadhana", "Logesh", "9688741481", "sadhu.lokii1924@gmail.com", "Bangalore","Logesh","mani","8870140494","suba","natraj","9750645623");
			Thread.sleep(2000);
			sw.dummyPayment("3742 454554 00126","sadhana", "08", "28", "123");
			Reports.reportStep("PASS", "Search with valid credentials passed");
			Thread.sleep(2000);
			screenshot("FlightBooking");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL", "Booking Flights failed");
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
