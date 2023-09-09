package com.spicejet.tests;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;
import com.spicejet.utils.Reports;
import com.spicejet.utils.SeWrappers;
import com.spicejet.utils.SpiceWrappers;

public class SpicejetLoginTest extends SeWrappers
{
	SpiceWrappers sw= new SpiceWrappers();
	SeWrappers se= new SeWrappers();

	@DataProvider(name="fetchData")
	public Object[][] readExcel() throws IOException
	{
		Object[][] data=null;
		XSSFWorkbook workbook=null;
	    DataFormatter dataFormatter = new DataFormatter();
		try
		{
			
			workbook= new XSSFWorkbook(System.getProperty("user.dir")+"/spicejet.xlsx");	
			XSSFSheet sheet= workbook.getSheet("testdata");
			XSSFRow row= sheet.getRow(0);
			
			int noOfRows=sheet.getPhysicalNumberOfRows();
			
			int noOfCells= row.getPhysicalNumberOfCells();
			
			data= new Object[noOfRows-1][noOfCells]; //data[5][2]
			
			for(int i=1; i<noOfRows;i++)
			{
				for(int j=0; j<noOfCells;j++)
				{
					 XSSFCell cell = sheet.getRow(i).getCell(j);
		                String cellValue = dataFormatter.formatCellValue(cell);
		                data[i - 1][j] = cellValue;
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			workbook.close();
		}
		
		return data;
	}
	@Test(dataProvider="fetchData")
	public void loginSpiceJet(String phNum,String pwd)
{
	try
	{
		Reports.setTCDesc("Validating login functionality with valid credentials");
		sw.launchBrowser();
		sw.loginSpicejet(phNum,pwd);
		Reports.setTCDesc("Searching OneWayFlight with valid credentials");
		sw.oneWayFlight(10);
	//	Reports.reportStep("PASS", "Login with valid credentials passed");
		
		screenshot("loginOneWay_valid");
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
	

