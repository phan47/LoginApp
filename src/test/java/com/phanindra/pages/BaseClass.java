package com.phanindra.pages;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.phanindra.utilities.BrowserFactory;
import com.phanindra.utilities.ConfigDataProvider;
import com.phanindra.utilities.ExcelDataProvider;
import com.phanindra.utilities.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up Reports and Test started", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+ "/Reports/LoginApp_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Settings Done - and Test can be started", true);
	}
	
	@BeforeClass
	public void setupApplication() {
		
		Reporter.log("Trying to start browser and getting application ready", true);
		
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		
		//System.out.println(driver.getTitle());
		
		Reporter.log("Browser and application is up and running", true);
	}
	
	@AfterClass
	public void tearDown() {
		
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		Reporter.log("Test is about to end", true);
		
		try {
			if(result.getStatus()==ITestResult.FAILURE) {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
			}
			else if(result.getStatus() == ITestResult.SUCCESS) {
				logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
			}
			else if(result.getStatus()==ITestResult.SKIP) {
				logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Unable to generate a Screenshot>>" +e.getMessage());
		}
		
		report.flush();
		
		Reporter.log("Test Completed >> Reports generated", true);
	}
	
}
