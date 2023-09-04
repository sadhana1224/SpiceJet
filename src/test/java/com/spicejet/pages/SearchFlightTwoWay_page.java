package com.spicejet.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;

public class SearchFlightTwoWay_page extends SeWrappers {

	@FindBy(xpath="//*[@data-testid='to-testID-origin']")
	WebElement origin;
	
	@FindBy(xpath="//div[text()='Bengaluru']")
	WebElement dep;
	
	@FindBy(xpath="//div[text()='Delhi']")
	WebElement des;
	
	@FindBy(xpath="//div[text()='Return Date']")
	WebElement retdate;
	
	@FindBy(xpath="//div[@data-testid='home-page-travellers']")
	WebElement travellers;
	
	@FindBy(xpath="//*[@data-testid='Adult-testID-plus-one-cta']")
	WebElement adults ;
	@FindBy(xpath="//*[@data-testid='Children-testID-plus-one-cta']")
	WebElement childrens ;
	@FindBy(xpath="//*[@data-testid='Infant-testID-plus-one-cta']")
	WebElement infants ;
	@FindBy(xpath="//div[contains(text(),'Currency')]")
	WebElement currency;
	
	@FindBy(xpath="(//div[contains(text(),'INR')])[1]")
	WebElement country;
	
	@FindBy(xpath="//div[contains(text(),'Search Flight')]")
	WebElement flights;	
	SeWrappers se= new SeWrappers();
	public void roundTrip()
	{
		click(origin);
		click(dep);
		click(des);
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
	
		click(clickDate);
		click(retdate);
		se.calender("November", "2023", "10");
	}
	
	
	public void flights() throws InterruptedException
	{
		click(travellers);
		for(int i=1;i<=3;i++)
		{
		click(adults);
		}
		for(int i=0;i<=2;i++)
		{
		click(childrens);
		}
		for(int i=0;i<=2;i++)
		{
			click(infants);
		}
		click(currency);
		click(country);
		actionClick(flights);
		Thread.sleep(8000);
	}
}
