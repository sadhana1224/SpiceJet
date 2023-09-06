package com.spicejet.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.spicejet.pages.SpicejetInPassesgerDet_NegativePage;
import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;

public class SpicejetInvalidPassengerDet_Negativetest extends SeWrappers
{
	SpiceWrappers sw= new SpiceWrappers();
	SeWrappers se= new SeWrappers();

	//negative test case
	@Test		
	public void SignUpInvalidCred()
	{
		try
		{
			Reports.setTCDesc("Booking Flight with invalid Passenger Details");
			sw.launchBrowser();
			sw.invalid_passengerDetails("9688741481", "Sadhumaa@123");
			sw.oneWayFlight(20);
			sw.bookingFlights("Sadhana", "Logesh", "9688741481", "sadhu.lokii1924@gmail.com", "Bangalore","Lo","mani","887014494","sub","natraj","975064623");
			Reports.reportStep("PASS", "InFormation is missing, Please Enter a Valid Passenger details");
			//screenshot("login_invalid");


		}
		catch(Exception ex)
		{
			//Reports.reportStep("FAIL", "Login failed");
			ex.printStackTrace();
		}
	}

	@AfterMethod
	public void closeBrowsers()
	{
		closeAllBrowsers();
	}
}

