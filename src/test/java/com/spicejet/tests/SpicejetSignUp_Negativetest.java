package com.spicejet.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;

public class SpicejetSignUp_Negativetest extends SeWrappers
{
	SpiceWrappers sw= new SpiceWrappers();
	SeWrappers se= new SeWrappers();
	//negative test case
	@Test		
		public void SignUpInvalidCred()
		{
			try
			{
				Reports.setTCDesc("Validating SignUp functionality with invalid credentials");
				sw.launchBrowser();
				sw.SignUp_invalidCredentials("Sad@", "v", "India", "9688741481", "abc@gmail", "Sadhu123","Sadhu123");
				//screenshot("login_invalid");
				
				
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

