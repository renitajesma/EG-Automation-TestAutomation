package com.wbg.selenium.qa.utils;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	static Logger log = LoggerHelper.getLogger(Waits.class);

	public boolean waitForElementClickable(WebDriver driver, WebElement element, long timeOut) {

		try {
			final WebDriverWait webDriverWait;
			webDriverWait = new WebDriverWait(driver, 10);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
			log.info("Element is clickable , " + "<" + element + ">" + ", TimeOut :" + timeOut);
			return true;
		} catch (Exception e) {
			log.info("Unable to click Element  , " + "<" + element.getClass() + ">" + ", TimeOut :" + timeOut);
			return false;

		}
	}

	public boolean waitForElementVisible(WebDriver driver, WebElement element, long timeOut) {

		try {
			final WebDriverWait webDriverWait;
			webDriverWait = new WebDriverWait(driver, 10);
			webDriverWait.until(ExpectedConditions.visibilityOf(element));
			log.info("Element is visible by locator , " + "<" + element + ">" + ", TimeOut :" + timeOut);
			return true;
		} catch (Exception e) {
			log.info("Unable to find Element  , " + "<" + element.getClass() + ">" + ", TimeOut :" + timeOut);
			return false;

		}

	}
	

}
