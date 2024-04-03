package com.wbg.selenium.qa.pageobject;

import java.net.URLEncoder;

import org.apache.log4j.Logger;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.wbg.selenium.qa.configReader.ConfigFileReader;
import com.wbg.selenium.qa.configReader.Xlsx_FileReader;
import com.wbg.selenium.qa.manager.FileReaderManager;
import com.wbg.selenium.qa.manager.WebDriverManagers;
import com.wbg.selenium.qa.utils.LoggerHelper;
import com.wbg.selenium.qa.utils.WebElementWrappers;

public class LoginPageobject extends WebDriverManagers {
	static Logger log = LoggerHelper.getLogger(LoginPageobject.class);
	ConfigFileReader fileReader = new ConfigFileReader();
	SoftAssert softAssert = new SoftAssert();
	/* Locators for web page */
	@FindBy(how = How.XPATH, using = "//input[@id='user-name']")
	WebElement username;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement password;
	@FindBy(how = How.XPATH, using = "//input[@id='login-button']")
	WebElement loginBtn;


	public  void navigateToApplication(String url,String userName,String Password) {
		try {
			System.out.println(url);
			System.out.println(userName);
			System.out.println(Password);
			driver.get(url);
			WebElementWrappers.enterText(username, userName);
			WebElementWrappers.enterText(password, Password);
			WebElementWrappers.clickElement(driver, loginBtn);
			log.info("User logged into the application successfully");
			Thread.sleep(2000);
			//driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());	
			Assert.fail("Application Dashboard is not displayed ");
		}

	}

	
}
