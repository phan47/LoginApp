package com.phanindra.utilities;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {
		public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
			if(browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "/Users/phanindrachoda/Documents/Drivers/chromedriver-mac-arm64/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equals("Firefox")) {
				//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				//driver = new ChromeDriver();
			}
			else if(browserName.equals("IE")) {
				//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				//driver = new ChromeDriver();
			}
			else {
				System.out.println("We do not support this browser");
			}
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			driver.get(appURL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			return driver;
			
		}
		
		public static void quitBrowser(WebDriver driver) {
			driver.quit();
		}
}
