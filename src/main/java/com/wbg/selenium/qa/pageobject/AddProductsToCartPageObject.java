package com.wbg.selenium.qa.pageobject;

import java.awt.AWTException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.wbg.selenium.qa.manager.WebDriverManagers;
import com.wbg.selenium.qa.utils.WebElementWrappers;
import java.util.ArrayList;
import java.util.Collections;

public class AddProductsToCartPageObject extends WebDriverManagers{
     public static SoftAssert softAssert = new SoftAssert();
	static Logger log = Logger.getLogger(AddProductsToCartPageObject.class);
	
	@FindBy(how = How.XPATH, using = "//a[@data-test='shopping-cart-link']")
	static WebElement addToCartLink;
	@FindBy(how = How.XPATH, using = "//div[@class='app_logo']")
	static WebElement logoittlte;
	@FindBy(how = How.XPATH, using = "//select[@data-test='product-sort-container']")
	static WebElement filterDropdown;
	@FindBy(how = How.XPATH, using = "//span[@data-test='shopping-cart-badge']")
	static WebElement cartNumberElement;
	
public static WebElement addTocart(String productName)
{
	return driver.findElement(By.xpath("//div[contains(text(),'"+productName+"')]/parent::a/../following-sibling::div//button"));
	}

//**Filter the products from low to high price or high to low price,accordingly the products are displayed **//*
public void filterTheproducts(String filterOption)
{
	WebElementWrappers.dropdown(filterDropdown, filterOption);

	       // Find all the product price elements
	        List<WebElement> priceElements = driver.findElements(By.xpath("//div[@data-test='inventory-item-price']"));
	        // Collect the prices into a list of strings
	        List<String> prices = new ArrayList<>();
	        for (WebElement priceElement : priceElements) {
	            prices.add(priceElement.getText().replace("$", ""));
	        }

	        // Convert the list of strings to a list of doubles
	        List<Double> pricesAsDoubles = new ArrayList<>();
	        for (String price : prices) {
	            pricesAsDoubles.add(Double.parseDouble(price));
	        }

	        // Create a sorted copy of the prices list
	        List<Double> sortedPrices = new ArrayList<>(pricesAsDoubles);
	        Collections.sort(sortedPrices);

	        // Validate that the prices are sorted from low to high
	        if (pricesAsDoubles.equals(sortedPrices)) {
	        	 System.out.println("Prices are not sorted from high to low.");
	        } else {
	        	System.out.println("Prices are sorted from high to low.");
	           
	        }

	}
	//**Verify that the user can add  more than1 product to the cart **//*
    //**Verify  the  valid homepage is displayed by validating the title   “Swag Labs” **//*
	public  void addItemsTotheCart(String appLogo,String productName1,String productName2 ) throws AWTException, InterruptedException
	{
		try {

			WebElementWrappers.customWaitForElementVisible(driver, logoittlte, 4000);
			String logoTitle=logoittlte.getText();
			softAssert.assertEquals(appLogo, logoTitle);
		
			 // Find and click on the "Add to cart" button for the first product
			WebElementWrappers.customWaitForElementClickable(driver, addTocart(productName1), 4000);
			WebElementWrappers.clickByJs(driver,addTocart(productName1));
	        // Wait for the cart icon to update
	        
			Thread.sleep(2000);
			WebElementWrappers.customWaitForElementClickable(driver,cartNumberElement, 4000);
	        // Find and get the text of the "Add to cart" number
	      
	        String cartNumberText = cartNumberElement.getText();
	        int cartNumber = Integer.parseInt(cartNumberText);

	        // Verify that the "Add to cart" number increases by 1
	        if (cartNumber == 1) {
	            System.out.println("Add to cart number increased by 1 after adding the first product.");
	        } else {
	            System.out.println("Add to cart number did not increase by 1 after adding the first product.");
	        }
			Thread.sleep(2000);
	        // Find and click on the "Add to cart" button for the second product
	        WebElementWrappers.customWaitForElementClickable(driver, addTocart(productName2), 4000);
	        WebElementWrappers.clickByJs(driver,addTocart(productName2));
	        // Wait for the cart icon to update
	        // Add appropriate wait logic here

	        // Get the updated text of the "Add to cart" number
	        cartNumberText = cartNumberElement.getText();
	        cartNumber = Integer.parseInt(cartNumberText);

	        // Verify that the "Add to cart" number increases by 1 again
	        if (cartNumber == 2) {
	            System.out.println("Add to cart number increased by 1 after adding the second product.");
	        } else {
	            System.out.println("Add to cart number did not increase by 1 after adding the second product.");
	        }
		}
		catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		}
	
}
