package com.phanindra.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseWithoutFramework {
	@Test
	public void test1() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		//driver.manage().timeouts().implicitlyWait(30);
		
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		driver.quit();
	}
}