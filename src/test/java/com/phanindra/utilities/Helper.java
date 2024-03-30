package com.phanindra.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

//import java.lang.Object.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
	
	//screenshots, alerts, frames, windows, sync issue, javascript executor
	public static String CaptureScreenshot(WebDriver driver) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/LoginApp_"+getCurrentDateTime() + ".png";
		
		try {
			FileHandler.copy(src, new File(screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture Screenshot" + e.getMessage());
		}
		
		return screenshotPath;
		
	}
	
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
		
		
	}
	
	

}
