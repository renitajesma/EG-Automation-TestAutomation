package com.wbg.selenium.qa.test;

import java.awt.AWTException;
import com.wbg.selenium.qa.manager.WebDriverManagers;
import com.wbg.selenium.qa.pageobject.AddProductsToCartPageObject;
import com.wbg.selenium.qa.pageobject.CheckoutPageObject;
import com.wbg.selenium.qa.pageobject.LoginPageobject;
import com.wbg.selenium.qa.pageobject.orderConfirmationPageObject;
import com.wbg.selenium.qa.pageobject.CartPageObject;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wbg.selenium.qa.configReader.Xlsx_FileReader;
import com.wbg.selenium.qa.manager.FileReaderManager;
import com.wbg.selenium.qa.pageobject.LoginPageobject;
import com.wbg.selenium.qa.services.GetAPIData;
import com.wbg.selenium.qa.utils.WebElementWrappers;

public class SauceDemo_Testcase extends WebDriverManagers {
	LoginPageobject loginPage;
	CheckoutPageObject CheckoutPage;
	AddProductsToCartPageObject AddProductsToCartPage;
	CartPageObject CartPage;
	orderConfirmationPageObject orderConfirmationPage;
	Xlsx_FileReader xlsx_FileReader = PageFactory.initElements(driver, Xlsx_FileReader.class);
	String inputSheetName = FileReaderManager.getInstance().getConfigReader().getInputSheetNameDA();
	String inputFilePath = FileReaderManager.getInstance().getConfigReader().getInputExcelPath();
	String inputGlobalSheet = FileReaderManager.getInstance().getConfigReader().getExcelGlobalSheetNameDA();
	XSSFSheet strInputSheetdata = WebElementWrappers.readExcel(inputFilePath, inputSheetName);
	int rowNum = WebElementWrappers.getRowNumber(this.getClass().getSimpleName(), strInputSheetdata);
	int rowNumGeneric = 2;
	boolean res=false;
	String kpiName = Xlsx_FileReader.excelreader.getCellData(inputSheetName, "labelName", rowNum).toString();
	List<String>valueUIL1=new ArrayList<>();
	String valueL2;

	@Test
	public void initializePageFactory() throws Exception {
		loginPage = PageFactory.initElements(driver, LoginPageobject.class);
		CheckoutPage = PageFactory.initElements(driver, CheckoutPageObject.class);
		AddProductsToCartPage= PageFactory.initElements(driver, AddProductsToCartPageObject.class);
		CartPage= PageFactory.initElements(driver, CartPageObject.class);
		orderConfirmationPage= PageFactory.initElements(driver, orderConfirmationPageObject.class);
		
		WebElementWrappers.Reporter(driver,
				"Load Class, User Should be able to load all classes for execution, User is  able to load all classes for execution ,Pass");

	}	
	@Test(dependsOnMethods = { "initializePageFactory" })
	public void loginToSauceDemo() throws InterruptedException {
		loginPage.navigateToApplication(
				
				Xlsx_FileReader.excelreader.getCellData(inputGlobalSheet, "url", rowNumGeneric),
				Xlsx_FileReader.excelreader.getCellData(inputSheetName, "username", rowNum),
				Xlsx_FileReader.excelreader.getCellData(inputSheetName, "password", rowNum));
	

	}

	//** Add items to the cart**//*

	@Test(priority=1)
	public  void addProductsToCart() throws Exception {
		//loginPage.openBrowser();
		try {
			AddProductsToCartPage.addItemsTotheCart(
					Xlsx_FileReader.excelreader.getCellData(inputSheetName, "appLogo", rowNum),
					Xlsx_FileReader.excelreader.getCellData(inputSheetName, "productName1", rowNum),
					Xlsx_FileReader.excelreader.getCellData(inputSheetName, "productName2", rowNum));


		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test(priority=2)
	public  void RemoveSomeProductsfromCartAndCheckout() throws Exception {
		
		try {
			CartPage.removeProductsFromCart(
					Xlsx_FileReader.excelreader.getCellData(inputSheetName, "productName2", rowNum));
			CartPage.selectCheckout();

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=3)
	public  void addcheckoutInformation() throws Exception {
		
		try {
			CheckoutPage.checkOutInformation(
					Xlsx_FileReader.excelreader.getCellData(inputSheetName, "firstName", rowNum),
					Xlsx_FileReader.excelreader.getCellData(inputSheetName, "lastName", rowNum),
					Xlsx_FileReader.excelreader.getCellData(inputSheetName, "Pincode", rowNum));
			

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=4)
	public  void verifyOrderConfirmation() throws Exception {
		
		try {
			orderConfirmationPage.orderConfimation();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}