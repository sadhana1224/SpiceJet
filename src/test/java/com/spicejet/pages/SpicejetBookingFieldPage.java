package com.spicejet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;

public class SpicejetBookingFieldPage extends SeWrappers {

	//check in 
	@FindBy(xpath="//div[@data-testid='check-in-horizontal-nav-tabs']")
	WebElement checkIn;

	@FindBy(xpath="//div[text()='Web Check-In']")
	WebElement eleInCheck;
	//flight-status
	@FindBy(xpath="//div[@data-testid='flight status-horizontal-nav-tabs']")
	WebElement flightStatus;

	@FindBy(xpath="//div[text()='Flight Status']")
	WebElement eleStatus;

	//manage Booking
	@FindBy(xpath="//div[@data-testid='manage booking-horizontal-nav-tabs']")
	WebElement manageBooking;

	@FindBy(xpath="//div[text()='Manage Booking']")
	WebElement bookingStatus;

	public void bookingFields() throws InterruptedException
	{
		//check in
		click(checkIn);
		if(eleInCheck.isDisplayed())
			Reports.reportStep("PASS","Check-In field successfully validated");
		else
			Reports.reportStep("FAIL","Problem while validating the Check-In field");

		Thread.sleep(2000);
		//flight status
		click(flightStatus);
		if(eleStatus.isDisplayed())
			Reports.reportStep("PASS","Flight status field successfully validated");
		else
			Reports.reportStep("FAIL","Problem while validating the Flight status field");
		Thread.sleep(2000);
		//manage booking
		click(manageBooking);
		if(bookingStatus.isDisplayed())
			Reports.reportStep("PASS","Manage Booking field successfully validated");
		else
			Reports.reportStep("FAIL","Problem while validating the Manage Booking  field");
		
		Thread.sleep(6000);

	}

}
