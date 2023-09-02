package com.spicejet.pages;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.model.Report;
import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;

public class SearchFlightOneWay_Page extends SeWrappers {

	/*@FindBy(xpath="//div[@data-testid='one-way-radio-button']")
	WebElement oneway;
*/
	@FindBy(xpath="//*[@data-testid='to-testID-origin']//input")
WebElement origin;
		
	
	@FindBy(xpath="//div[text()='Delhi']")
	WebElement departure;

	@FindBy(xpath="//div[@class='css-1dbjc4n r-b5h31w r-95jzfe']//div[text()='Chennai']")
	WebElement destination;
	@FindBy(xpath="//div[@data-testid='home-page-travellers']")
	WebElement travellers;

	@FindBy(xpath="//*[@data-testid='Adult-testID-plus-one-cta']")
	WebElement adults; 

	@FindBy(xpath="//*[@data-testid='Children-testID-plus-one-cta']")
	WebElement childrens; 

	@FindBy(xpath="//*[@data-testid='Infant-testID-plus-one-cta']")
	WebElement infants; 

	@FindBy(xpath="//div[contains(text(),'Currency')]")
	WebElement currency; 

	@FindBy(xpath="(//div[contains(text(),'INR')])[1]")
	WebElement chooseCurrency;

	@FindBy(xpath="//div[contains(text(),'Search Flight')]")
	WebElement flights;
/*
	public void clickOneway()
	{
		click(oneway);
	}
	*/ 
	public void clickOrigin()
	{
		click(origin);
		typeText(origin,"DEL");
		//click(departure);
		click(destination);
		//typeText(origin,"DEL");
		
		
	}	

	public void  Choosedate(int futureDay)
	{
		Reports.reportStep("INFO", "Clicking the Dates");
		// Add 20 days to the current date to get the future date
		LocalDate futureDate = LocalDate.now().plusDays(futureDay);
		// Extract the day, month, and year from the future dat     
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
		final String date = String.valueOf(futureDate.getDayOfMonth());
		final String month = futureDate.format(formatter);
		final String year = String.valueOf(futureDate.getYear());
		WebElement	clickDate=driver.findElement(By.xpath(" //div[contains(@data-testid,'month-"+month+"-"+year+"')]//div[@data-testid='undefined-calendar-day-"+date+"']/div"));
	
		if(click(clickDate))
			Reports.reportStep("PASS","Clicked the JourneyDate");
		else
			Reports.reportStep("FAIL","Not Clicked the  JourneyDate");

	}

	public void ChooseTravellers()
	{
		if(click(travellers))
			Reports.reportStep("PASS","Clicked the Travellers");
		else
			Reports.reportStep("FAIL","Not Clicked the  Travellers");

	}

	public void ChooseAdults()
	{
		
		for(int i=1;i<=2;i++)
		{
			if(click(adults))
				Reports.reportStep("PASS","Choosed No.of adults");
			else
				Reports.reportStep("FAIL","Not Choosed No.of adults");
		}
	}
	/*
	public void chooseChilds()
	{
		for(int i=0;i<=2;i++)
		{
			if(click(childrens))
				Reports.reportStep("PASS","choosed  No.of Childrens passengers");
			else
				Reports.reportStep("FAIL","Not choosed  No.of Childrens passengers");

		}
	}
	public void chooseInfants()
	{
		for(int i=0;i<=2;i++)
		{
			if(click(infants))
				Reports.reportStep("PASS","choosed  No.of infants passengers");
			else
				Reports.reportStep("FAIL","Not choosed  No.of infants passengers");
		}

	}
	*/
	public void clickCurrency()
	{
		if(click(currency))
			Reports.reportStep("PASS","Clicked the currency");
		else
			Reports.reportStep("FAIL","Not Clicked the currency");
	
	}
	
	public void chooseCurrency()
	{
		if(click(chooseCurrency))
			Reports.reportStep("PASS","choosed  the Currency");
		else
			Reports.reportStep("FAIL","Not choosed  the Currency");

	}

	public void searchFlights()
	{

		actionClick(flights);

	}



}
