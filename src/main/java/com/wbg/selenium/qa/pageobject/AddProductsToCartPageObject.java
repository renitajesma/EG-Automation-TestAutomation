package com.wbg.selenium.qa.pageobject;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.wbg.selenium.qa.manager.WebDriverManagers;
import com.wbg.selenium.qa.utils.WebElementWrappers;

public class AddProductsToCartPageObject extends WebDriverManagers{
     public static SoftAssert softAssert = new SoftAssert();
	static Logger log = Logger.getLogger(AddProductsToCartPageObject.class);
	
	@FindBy(how = How.XPATH, using = "//a[@data-test='shopping-cart-link']")
	static WebElement addToCartLink;
	@FindBy(how = How.XPATH, using = "//div[@class='app_logo']")
	static WebElement logoittlte;
	

public static WebElement addTocart(String productName)
{
	return driver.findElement(By.xpath("//div[contains(text(),'"+productName+"')]/parent::a/../following-sibling::div//button"));
	}

	//**Add Products to the Cart **//*
	public  void addItemsTotheCart(String appLogo,String productName1,String productName2 ) throws AWTException, InterruptedException
	{
		try {
			Thread.sleep(2000);
			String logoTitle=logoittlte.getText();
			softAssert.assertEquals(appLogo, logoTitle);
			WebElementWrappers.clickByJs(driver,addTocart(productName1));
			WebElementWrappers.clickByJs(driver,addTocart(productName2));
			WebElementWrappers.clickByJs(driver,addToCartLink);
			
		
		}
		catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		}
	
}
