package com.spicejet.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports 
{
/*
 * ExtentSparkReporter --> This class is used to generate the html report file
 * ExtentReports--> This class is used to create the tests in Extent reports
 * ExtentTest  --> This class is used to generate the logs for each test case
 */

public static ExtentSparkReporter sparkReporter;

public static ExtentReports extentReports;

public static ExtentTest extentTest;


@BeforeSuite(alwaysRun=true)
public static void startReport()
{
	try
	{
		//chrome
		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/SpicejetWebAutomationReport.html");
		sparkReporter.config().setDocumentTitle("Spicejet Web Automation Report");
		sparkReporter.config().setReportName("SpiceJet Web Automation");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extentReports= new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		
		
	
	
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}

public static void setTCDesc(String testcaseName)
{
	try
	{
		extentTest=extentReports.createTest(testcaseName);
		
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}

public static void reportStep(String status,String desc)
{
	try
	{
		
		if(status.equalsIgnoreCase("PASS"))
		{
			extentTest.log(Status.PASS, desc);
		}
		else if(status.equalsIgnoreCase("FAIL"))
		{
			extentTest.log(Status.FAIL, desc);
		}
		else if (status.equalsIgnoreCase("SKIP"))
		{
			extentTest.log(Status.SKIP, desc);
		}else if (status.equalsIgnoreCase("INFO"))
		{
			extentTest.log(Status.INFO, desc);
		}
		
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}


public static void takeScreeenShot(WebDriver driver,String screenshotName)
{
	try
	{	
		 try {
			File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest= new File(System.getProperty("user.dir")+"/screenshots/"+screenshotName+".png");
			FileUtils.copyFile(source, dest);
            extentTest.addScreenCaptureFromPath(dest.toString());
          } catch (IOException e) {
  			extentTest.log(Status.WARNING, "Unable to take screenshots");
            e.printStackTrace();
          }
		
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}

@AfterSuite(alwaysRun=true)
public void endReport()
{
	try
	{
		extentReports.flush();
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}
}
