package com.phanindra.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.phanindra.pages.BaseClass;
import com.phanindra.pages.LoginPage;
import com.phanindra.utilities.BrowserFactory;
import com.phanindra.utilities.ExcelDataProvider;
import com.phanindra.utilities.Helper;

public class LoginTest extends BaseClass{
	
	
	@Test(priority=1)	
	public void loginApp() {
		
		logger = report.createTest("Login to App");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		
		loginPage.loginToApp(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login success");
		
		
	}
	
}
