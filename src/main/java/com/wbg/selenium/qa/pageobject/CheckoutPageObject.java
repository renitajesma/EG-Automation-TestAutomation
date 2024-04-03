package com.wbg.selenium.qa.pageobject;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.wbg.selenium.qa.manager.WebDriverManagers;
import com.wbg.selenium.qa.utils.WebElementWrappers;

public class CheckoutPageObject extends WebDriverManagers{

	static Logger log = Logger.getLogger(CheckoutPageObject.class);
	SoftAssert softAssert = new SoftAssert();
	public static String additionalitySummaryFromDashboard=null;
	@FindBy(how = How.XPATH, using = "//input[@id='first-name']")
	static WebElement firstname;
	@FindBy(how = How.XPATH, using = "//input[@id='last-name']")
	static WebElement lastname;
	@FindBy(how = How.XPATH, using = "//input[@id='postal-code']")
	static WebElement postalcode;
	@FindBy(how = How.XPATH, using = "//input[@id='continue']")
	static WebElement continueBtn;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Finish')]")
	static WebElement finishBtn;
	@FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']")
	static WebElement errorMessage;
	
	public void verifytheErrorMessage() throws InterruptedException
	{
		WebElementWrappers.scrollDown(driver);
		WebElementWrappers.customWaitForElementClickable(driver, continueBtn, 2000);	
		WebElementWrappers.clickElement(driver, continueBtn);
		String ExpectedErrorMessage="error-message-container error";
		String ActualErrorMessage=errorMessage.getText();
		softAssert.assertEquals(ExpectedErrorMessage, ActualErrorMessage);
		
	}

	public  void checkOutInformation(String firstName,String lastName,String Pincode ) throws AWTException, InterruptedException
	{
		try {
			WebElementWrappers.customWaitForElementVisible(driver, firstname, 4000);	
			Thread.sleep(2000);
			WebElementWrappers.enterText(firstname, firstName);
			WebElementWrappers.enterText(lastname, lastName);
			WebElementWrappers.enterText(postalcode, Pincode);
			WebElementWrappers.scrollDown(driver);
			Thread.sleep(2000);
			WebElementWrappers.customWaitForElementClickable(driver, continueBtn, 4000);	
			WebElementWrappers.clickElement(driver, continueBtn);
			Thread.sleep(2000);
			WebElementWrappers.customWaitForElementClickable(driver, finishBtn, 4000);	
			WebElementWrappers.clickElement(driver, finishBtn);
			Thread.sleep(2000);
		}
		catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		}
	
}
