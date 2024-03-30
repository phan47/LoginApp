package com.phanindra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
		
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(name="username") WebElement uname;
	
	@FindBy(name="password") WebElement pass;
	
	@FindBy(xpath="/html/body/form/input[3]") WebElement loginButton;
	
	public void loginToApp(String usernameApplication, String passwordApplication) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		loginButton.click();
	}
}
