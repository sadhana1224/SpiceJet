package com.spicejet.tests;

import org.testng.annotations.Test;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;

public class SpicejetSignUpTest extends SeWrappers {
	SpiceWrappers sw= new SpiceWrappers();
	SeWrappers se= new SeWrappers();

	@Test
	public void signUpPage()
	{
		try
		{
			Reports.setTCDesc("Validating SignUp functionality with valid credentials");
			sw.launchBrowser("https://www.spicejet.com/");
			sw.signupSpicejet("Sadhana", "Vengadashalam", "India", "9688741481","sadhu.lokii1924@gmail.com","Sadhumaa@123","Sadhumaa@123");
			Reports.reportStep("PASS", "SignUp with valid credentials passed");

			//screenshot("signup_valid");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL", "SignUp failed");
			ex.printStackTrace();
		}	
	}
}
