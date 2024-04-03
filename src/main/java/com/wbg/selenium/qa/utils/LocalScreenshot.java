package com.wbg.selenium.qa.utils;

import com.wbg.selenium.qa.manager.WebDriverManagers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import java.io.File;

public class LocalScreenshot extends TestListenerAdapter {

	String Seperator = System.getProperty("file.separator");

	
	/*
	 * @description : Capture the screen short  and  create a folder screenshot on test failure
	 * @param :
	 * @return : 
	 * @date : 28 Dec 2020
	 *
	 */

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		Reporter.setCurrentTestResult(result);
		String sTestClassName = result.getTestClass().getRealClass().getSimpleName();
		System.out.println("Test class name ..." + sTestClassName);
		String sFileName = result.getName();
		System.out.println("Test method name ..." + sFileName);
		driver = WebDriverManagers.gerDriverDetails(result.getTestClass().getName());
		/* Capture the screenshot */
		String imagePathInHost = "file:results"+Seperator+ "screenshots" + Seperator
				+ "LatestResults" + Seperator + sTestClassName + Seperator
				+ captureScreenshot(driver, sTestClassName, sFileName);
		System.out.println("Image path...." + imagePathInHost);
		//Reporter.log("<a href=" + imagePathInHost + "> Fail </a>");
		Reporter.setCurrentTestResult(null);

	}
	
	/*
	 * @description : Capture the screen short  and  create a folder screenshot on test Success
	 * @param :
	 * @return : 
	 * @date : 28 Dec 2020
	 *
	 */

	@Override
	public void onTestSuccess(ITestResult result) {
		WebDriver driver = null;
		Reporter.setCurrentTestResult(result);
		String sTestClassName = result.getTestClass().getRealClass().getSimpleName();
		System.out.println("Test class name ..." + sTestClassName);
		String sFileName = result.getName();
		System.out.println("Test method name ..." + sFileName);
		driver = WebDriverManagers.gerDriverDetails(result.getTestClass().getName());
		/* Capture the screenshot */
		String imagePathInHost = "file:results"+Seperator+ "screenshots" + Seperator
				+ "LatestResults" + Seperator + sTestClassName + Seperator
				+ captureScreenshot(driver, sTestClassName, sFileName);
		System.out.println("Image path...." + imagePathInHost);
	//	Reporter.log("<a href=" + imagePathInHost + "> Pass</a>");

		Reporter.setCurrentTestResult(null);

	}

	/*
	 * @description : Print Skipped in report HTML if test case is skipped
	 * @param :
	 * @return : 
	 * @date : 28 Dec 2020
	 *
	 */

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.setCurrentTestResult(result);
		String sTestClassName = result.getTestClass().getRealClass().getSimpleName();
		System.out.println("Test class name ..." + sTestClassName);
		String sFileName = result.getName();
		System.out.println("Test method name ..." + sFileName);
	//	Reporter.log("<a> Skipped </a>");
		Reporter.setCurrentTestResult(null);

	}
	

	/*
	 * @description : Capture the screen short  and  create a folder screenshot 
	 * @param :
	 * @return : 
	 * @date : 28 Dec 2020
	 *
	 */

	public String captureScreenshot(WebDriver driver, String sTestClassName, String sFileName) {
		sFileName = sFileName + ".png";
		try {
			File file = new File("test-output"+Seperator+"results"+Seperator+"screenshots" + Seperator + "LatestResults" + Seperator + sTestClassName);
			if (!file.exists()) {
				System.out.println("File created somewhere" + file);
				file.mkdir();
			}
			/* Capture the screenshots */
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//.out.println("sourceFile" + sourceFile);
			File targetFile = new File("test-output"+Seperator+"results"+Seperator+"screenshots" + Seperator + "LatestResults" + Seperator + sTestClassName,
					sFileName);
		//	System.out.println("targetFile" + targetFile);
			//* Copy the screen shot to target file */
			FileUtils.copyFile(sourceFile, targetFile);
		//	System.out.println("copy");
			return sFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
