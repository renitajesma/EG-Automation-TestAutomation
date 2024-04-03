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

import com.wbg.selenium.qa.manager.WebDriverManagers;
import com.wbg.selenium.qa.utils.WebElementWrappers;

public class CartPageObject extends WebDriverManagers{

	static Logger log = Logger.getLogger(CartPageObject.class);
	
	@FindBy(how = How.XPATH, using = "//button[@id='continue-shopping']")
	static WebElement continueShoppingLink;
	@FindBy(how = How.XPATH, using = "//button[@id='checkout']")
	static WebElement checkout;
	@FindBy(how = How.XPATH, using = "//input[@id='continue']")
	static WebElement continueBtn;
	
	
	public static WebElement removeCart(String productName)
	{
		return driver.findElement(By.xpath("//div[contains(text(),'"+productName+"')]/parent::a/following-sibling::div//button"));
		}
	//**Remove products from cart **//*
	public void removeProductsFromCart(String productName2 ) throws AWTException, InterruptedException
	{
		try {
			Thread.sleep(2000);
			System.out.println("entered summary");
			WebElementWrappers.clickElement(driver, removeCart(productName2));
		}
		catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		}
	//**Continue Shopping **//*
		public void continueShopping() throws AWTException, InterruptedException
		{
			try {
				Thread.sleep(2000);
				WebElementWrappers.clickElement(driver, continueShoppingLink);
			}
			catch (Exception e) {
				log.info(e.getMessage());
				e.printStackTrace();
				Assert.assertTrue(false);
			}
			}
		//**Continue Shopping **//*
		public  void selectCheckout() throws AWTException, InterruptedException
		{
			try {
				Thread.sleep(2000);
				WebElementWrappers.clickElement(driver, checkout);
			}
			catch (Exception e) {
				log.info(e.getMessage());
				e.printStackTrace();
				Assert.assertTrue(false);
			}
			}
		public  void selectcontinue() throws AWTException, InterruptedException
		{
			try {
				Thread.sleep(2000);
				WebElementWrappers.scrollDown(driver);
				WebElementWrappers.clickElement(driver, continueBtn);
			}
			catch (Exception e) {
				log.info(e.getMessage());
				e.printStackTrace();
				Assert.assertTrue(false);
			}
			}
}
