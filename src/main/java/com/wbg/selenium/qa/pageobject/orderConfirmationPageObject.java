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

public class orderConfirmationPageObject extends WebDriverManagers{

	static Logger log = Logger.getLogger(orderConfirmationPageObject.class);
	SoftAssert softAssert = new SoftAssert();
	@FindBy(how = How.XPATH, using = "//img[@data-test='pony-express']")
	static WebElement orderSucess;
	
	//**Validate the order confirmation message **//*
	public  void orderConfimation( ) throws AWTException, InterruptedException
	{
		try {
			
			boolean orderSucessIndication=orderSucess.isDisplayed();
			softAssert.assertTrue(orderSucessIndication);
		}
		catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
			WebElementWrappers.Reporter(driver, "Verify that Additionality summary is  added,The Additionality summary should not be added successfully, The Additionality summary is not added successfully,Fail");
			Assert.assertTrue(false);
		}
	
}
}