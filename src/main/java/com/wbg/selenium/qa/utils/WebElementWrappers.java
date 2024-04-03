package com.wbg.selenium.qa.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.wbg.selenium.qa.configReader.MapDataProvider;
import com.wbg.selenium.qa.configReader.Xlsx_FileReader;
import com.wbg.selenium.qa.manager.FileReaderManager;
import com.wbg.selenium.qa.manager.WebDriverManagers;


public class 	WebElementWrappers{
	static Logger log = Logger.getLogger(WebElementWrappers.class);
	static String Seperator = System.getProperty("file.separator");

	static WebDriverWait wait;
	public static JavascriptExecutor js;

	public static void clickbyActionClass(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			log.info(e.getMessage());
			WebElementWrappers.Reporter(driver,
					"Verify the element is clickable,Element should be clickable,Element is not clickable,Fail");
			Assert.assertTrue(false);
		}
	}
	
 
	public static void selectDropDown(WebDriver driver, String value, WebElement element, String tagname) {
		try{WebElementWrappers.clickElement(driver, element);
		List<WebElement> items = element.findElements(By.tagName(tagname));
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getText().equals(value)) {
				items.get(i).click();
				break;
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enterTextByJs(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.BACK_SPACE);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value = arguments[1];", element, text);
		element.sendKeys(Keys.ENTER);
	}

	public static void enterTextByJavascript(WebDriver driver, WebElement element, String text) {
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.BACK_SPACE);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value = arguments[1];", element, text);
		element.sendKeys(Keys.ENTER);
	}

	public static void valiadateMaxChars(WebDriver driver, WebElement element, String text) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.BACK_SPACE);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[1].value=arguments[0]", text, element);
		element.sendKeys(Keys.ENTER);
	
		String enetredText = element.getAttribute("value");
		int size = enetredText.length();

		if (size <= 2000) {
			System.out.println("Entered maximum of 2000 characters");

		} else if (size > 2000) {
			System.out.println("User can enter more than maximum of 2000 characters");
		}
	}

	public static void doubleClickonElement(WebDriver driver, WebElement element) {

		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// reusable method to wait for element visible
	public static WebElement waitForElementVisible(WebDriver driver, WebElement element) {
		try {
			wait = new WebDriverWait(driver, 120);
			element = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			log.info(e.getMessage());
			WebElementWrappers.Reporter(driver,
					"Verify the element is visible,Element should be visible,Element is not visible,Fail");
			Assert.assertTrue(false);
		}
		return element;
	}

	public static WebElement customWaitForElementVisible(WebDriver driver, WebElement element, int intWait) {

		wait = new WebDriverWait(driver, intWait);
		element = wait.until(ExpectedConditions.visibilityOf(element));

		return element;
	}

	public static boolean customWaitForElementClickable(WebDriver driver, WebElement element,int seconds) {

	        try {

	            wait = new WebDriverWait(driver, seconds);

	            element = wait.until(ExpectedConditions.elementToBeClickable(element));

	            return true;

	        } catch (Exception e) {

	            return false;

	        }

	    }

	public static boolean customwaitForElementListExists(WebDriver driver, List<WebElement> element,int seconds) {
        try {
            wait = new WebDriverWait(driver, seconds);
            log.info(element);
            element = wait.until(ExpectedConditions.visibilityOfAllElements(element));
            return true;
        } catch (Exception e) {
            log.info(e.getMessage());
            return false;
        }

    }
	public static List<WebElement> customWaitForVisiblilityofAllElements(WebDriver driver, List<WebElement> element,
			int intWait) {

		wait = new WebDriverWait(driver, intWait);
		element = wait.until(ExpectedConditions.visibilityOfAllElements(element));
		return element;
	}
	// reusable method to click on element using Js
	public static void clickByJs(WebDriver driver, WebElement element) {

		JavascriptExecutor j1 = ((JavascriptExecutor) driver);
		j1.executeScript("arguments[0].click();", element);

	}

	// reusable method to click on element
	public static void clickElement(WebDriver driver, WebElement element) {
		/*
		 * if(element.isEnabled()) { element.click();
		 * WebElementWrappers.Reporter(driver,"Click on the "+element.getText().trim()
		 * +",Element "+element.getText().trim()+" should be clicked ," +
		 * "Element "+element.getText().trim()+" is clicked ,Pass"); } else {
		 * WebElementWrappers.Reporter(driver,"Click on the "+element.getText().trim()
		 * +",Element "+element.getText().trim()+" should be clicked ," +
		 * "Element "+element.getText().trim()+" is not clicked ,Pass"); }
		 */
		element.click();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();", element);
		 */
		// js.executeScript("arguments[0].setAttribute('style', 'background: yellow;
		// border: 2px solid red;');", element);

	}

	// reusable method to send text to element

	public static void enterText(WebElement element, String text) {
		element.click();
		// element.clear();
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.BACK_SPACE);
		element.sendKeys(text);

	}

	/*
	 * public static void enterTextForElement(String xpath,WebElement
	 * element,WebDriver driver, String text) {
	 * 
	 * element.sendKeys(Keys.CONTROL + "a" ); element.sendKeys(Keys.BACK_SPACE);
	 * driver.findElement(By.xpath("+"xpath"+")).clear();
	 * 
	 * }
	 */

	public static String getText(WebDriver driver, WebElement element) {
		JavascriptExecutor j1 = ((JavascriptExecutor) driver);
		String value = (String) j1.executeScript("return arguments[0].value", element);
		return value;
	}

	// reusable method to scroll to element
	public static void scrollToElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}
	// reusable method to scroll Up
		public static void scrollUp(WebDriver driver) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		}
		
	public static void scrollDown(WebDriver driver) {
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		}

	public static void scrollToElementCenter(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.assertTrue(false);
		}
	}

	// reusable method to highlight element
	public static void highlightElement(WebDriver driver, WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void expandTabSection(WebDriver driver, WebElement element) {

		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('class','collapse show')", element);
	}

	public static boolean waitForPageLoad(WebDriver driver) {

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			// @Override
			public Boolean apply(WebDriver driver) {
				try {
					Long r = (Long) ((JavascriptExecutor) driver).executeScript("return $.active");
					return r == 0;
				} catch (Exception e) {
					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			// @Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	// reusable method to capture screenshot
	public static void captureScreenshot(WebDriver driver, String stringFileName) {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("Screenshots//Screenshot_" + stringFileName + ".jpg"));
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public static void mouseHoverElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).clickAndHold().build().perform();
	}

	public static boolean isElementEnabled(WebDriver driver, WebElement element) {
		WebElement ele = waitForElementVisible(driver, element);
		return ele.isEnabled();

	}

	public static String getAttribute(WebElement element, String name) {

		return element.getAttribute(name);

	}

	public static void getTitle(WebDriver driver, String value) {
		if (driver.getTitle().equalsIgnoreCase(value))
			log.info(value + " page is initiated successfully");
		else
			log.info(value + " page is not initiated successfully");

	}

	// reusable method to select a text from dropdown
	public static void dropdown(WebElement element, String textToBeSelected) {
		Select s = new Select(element);
		s.selectByVisibleText(textToBeSelected);
	}

	// reusable method to select a text from dropdown
	public static void selectDropdownByValue(WebElement element, String value) {

		Select s = new Select(element);
		s.selectByValue(value);
	}

	public static void selectDropdownByValueByLocator(By xpath, String value) {
		Select s = new Select((WebElement) xpath);
		s.selectByValue(value);

	}

	public static String getElementText(WebElement element) {
		return element.getText().trim();
	}

	public static void switchFrame(WebDriver driver, int intTime, int intIndex) throws InterruptedException {
		
		wait = new WebDriverWait(driver, intTime);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(intIndex));
	}

	public static void switchFrameClickElement(WebDriver driver, WebElement element) throws InterruptedException {
		int size = driver.findElements(By.tagName("iframe")).size();
		log.info("Number of frames on " + element + " is : " + size);

		for (int i = 0; i <= size; i++) {
			WebElementWrappers.switchFrame(driver, 5, i);
			WebElementWrappers.customWaitForElementVisible(driver, element, 5);

			if (element.isDisplayed()) {
				log.info("Element present on frame " + i);

				element.click();
				break;
			}
		}
		driver.switchTo().defaultContent();
	}

	public static void switchFrameEnterText(WebDriver driver, WebElement element, String value)
			throws InterruptedException {
		int size = driver.findElements(By.tagName("iframe")).size();
		log.info("Number of frames = " + size);

		for (int i = 0; i <= size; i++) {
			WebElementWrappers.switchFrame(driver, 10, i);
			if (element.isDisplayed()) {
				log.info("Element present on frame " + i);
				element.clear();
				WebElementWrappers.enterText(element, value);
				break;
			}
		}
		driver.switchTo().defaultContent();
	}

	public static String datePlusFive() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 1); // Adding 1 days
		String output = sdf.format(c.getTime());
		log.info("Get datevalue : " + output);
		return output;
	}

	public static String todaysDate() {
		Date date = new Date();
		String dateFormat = "MM/dd/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		log.info("Today is " + sdf.format(date));
		return sdf.format(date);
	}

	public static void enableCheckBox(WebDriver driver, WebElement element) {
		WebElementWrappers.waitForElementVisible(driver, element);
		if (element.isSelected()) {
			log.info("Checkbox " + element + " was already enabled");
		} else {
			element.click();
			log.info("Checkbox " + element + " was enabled successfully");
		}
	}

	public static String randomString() {

		SecureRandom random = new SecureRandom();
		return new BigInteger(20, random).toString();
	}

	public static void keysdown(WebDriver driver, int sequence) throws InterruptedException {

		Actions action = new Actions(driver);
		for (int i = 0; i < sequence; i++) {
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
		
			// element.sendKeys(Keys.ARROW_DOWN);
			// action.moveToElement(element).sendKeys(Keys.ARROW_DOWN).build().perform();

		}
	}

	public static void pagedown(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();

	}

	public static void waitforelementToBeClickable(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			Assert.assertTrue("Element is not visible or not clickable", false);
		}
	}

	public static void waitForFileDownloaded(WebDriver driver, File file, int timeoutSeconds) {
		// WebDriver driver = getDriver();
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutSeconds))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
		wait.until((webDriver) -> file.exists());
	}

	public static void keysUp(WebDriver driver, int sequence) throws InterruptedException {
		Actions action = new Actions(driver);
		for (int i = 0; i < sequence; i++) {
			action.sendKeys(Keys.ARROW_UP).build().perform();
	
		}
	}

	public static void keysRight(WebDriver driver, int sequence) throws InterruptedException {
		Actions action = new Actions(driver);
		for (int i = 0; i < sequence; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();
		
		}
	}

	public static void pagedown(WebDriver driver, int iteration) throws InterruptedException {
		Actions action = new Actions(driver);

		for (int i = 0; i < iteration; i++) {

			action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		}

	}

	public static void pageUp(WebDriver driver, int iteration) throws InterruptedException {
		Actions action = new Actions(driver);

		for (int i = 0; i < iteration; i++) {

			action.sendKeys(Keys.PAGE_UP).build().perform();
			
		}

	}

	/*
	 *
	 ******************************************************************************** 
	 * Created by - Raghul Raj Date Created - 24th June 2020 Description - Method to
	 * decode Base64 encoded String. Input Parameters - Base64 encoded String
	 *
	 ********************************************************************************
	 */

	public static String decodeString(String encodedString) {
		byte[] decoded = Base64.getDecoder().decode(encodedString);
		return new String(decoded, StandardCharsets.UTF_8);
	}

	/*
	 *
	 ******************************************************************************** 
	 * Created by - Raghul Raj Date Created - 25th June 2020 Description - Method to
	 * return a list of options available in a dropdown under tag <li> Input
	 * Parameters - Webelement dropdown
	 *
	 ********************************************************************************
	 */

	public static List<String> getDropdownValuesbyTagLi(WebElement drpElement) {
		List<WebElement> options = drpElement.findElements(By.tagName("li"));
		List<String> drpOptions = new ArrayList<>();

		for (WebElement option : options) {
			drpOptions.add(option.getText());
		}
		return drpOptions;
	}

	/*
	 *
	 ******************************************************************************** 
	 * Created by - Raghul Raj Date Created - 25th June 2020 Description - Method to
	 * verify actual and expected values in a list Input Parameters - Actual and
	 * expected lists
	 *
	 ********************************************************************************
	 */

	public static void compareLists(List<String> actualList, List<String> expectedList) {
		// Check for nulls
		if ((actualList.isEmpty() || expectedList.isEmpty())) {
			log.info("One of the lists to be compared is empty");
			// Assert.assertTrue(false);
		} else {
			for (int i = 0; i < expectedList.size(); i++) {
				if (actualList.contains(expectedList.get(i))) {
					log.info(expectedList.get(i) + " is present in the actual values list");
				} else {
					log.info(expectedList.get(i) + " is not present in the actual values list");
					Assert.assertTrue(false);

				}
			}
		}
	}

	/*
	 *
	 ******************************************************************************** 
	 * Created by - Raghul Raj Date Created - 29th June 2020 Description - Method to
	 * verify actual and expected values in a list Input Parameters - Actual and
	 * expected lists
	 *
	 ********************************************************************************
	 */

	public static WebElement getDropdownValuesbyTagLi(WebDriver driver, String value) {
		return driver.findElement(By.xpath("//ul//li[contains(text(),'" + value + "')]"));
	}

	public static void selectDropdownValuesbyTagLi(WebDriver driver, WebElement element, String value) {
		driver.findElement(By.xpath("//ul//li[contains(text(),'" + value + "')]")).click();
		element.sendKeys(Keys.ENTER);

	}

	public static void scrollDownByPageDown() throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
	}

	public static List<String> getCellValueFromTable(int cellNumber, List<WebElement> tableRows) {
		List<String> cellValue = new ArrayList<>();
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			cellValue.add(cells.get(cellNumber).getText().trim());
		}
		return cellValue;
	}

	public static List<String> getTableHeadersByTh(WebElement tableRows) {
		List<String> cellValue = new ArrayList<>();
		List<WebElement> cells = tableRows.findElements(By.tagName("th"));
		for (int i = 0; i < cells.size(); i++) {
			cellValue.add(cells.get(i).getText().toLowerCase().trim());
		}
		return cellValue;
	}

	public static String getExcelValue(String workSheet, String column, int i) throws IOException {
		MapDataProvider mpd = new MapDataProvider();
		List<Map<String, String>> getMap = mpd.getData(workSheet);
		// getMap.
		return getMap.get(i).get(column);
	}

	// getting values from excel
	public static String getKeyValue(String key, int i) throws IOException {
		MapDataProvider mpd1 = new MapDataProvider();
		List<Map<String, String>> getMap = mpd1.getData("TestData");
		return getMap.get(i).get(key);
	}

	public static String getExcelValueByScenario(String workSheet, String column, String scenarioName)
			throws IOException {
		int i;
		boolean isScenarioPresent = false;
		String result = null;
		MapDataProvider mpd = new MapDataProvider();
		List<Map<String, String>> getMap = mpd.getData(workSheet);

		if (getMap.isEmpty()) {
			log.info("No rows found in the excel worksheet " + workSheet);
			Assert.fail();
		} else {
			for (i = 0; i < getMap.size(); i++) {
				if (getMap.get(i).get("ScenarioName").equalsIgnoreCase(scenarioName)) {
					log.info("Scenario name found in the excel - '" + getMap.get(i).get("ScenarioName") + "'");
					result = getMap.get(i).get(column);
					log.info("Value retrieved from excel - '" + result + "'");
					isScenarioPresent = true;
					break;
				}
			}
		}
		if (!isScenarioPresent) {
			log.info("Scenario name is not present in the excel");
			Assert.fail();
		}
		return result;
	}

	public static List<String> splitStringReturnList(String value, String splitBy) throws IOException {
		return Arrays.asList(value.split(splitBy));
	}

	public static void scrollToElementByActionClass(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public static void assertElementPresentGetText(WebDriver driver, WebElement element) {
		if (element.isDisplayed()) {
			log.info("Element, '" + element.getText().trim() + "' is present in the application");
			WebElementWrappers.Reporter(driver,
					"Verify presence of element,Element " + element.getText().trim() + " should be present on the page,"
							+ "Element " + element.getText().trim() + " presence is verified ,Pass");
			Assert.assertTrue(true);
		} else {
			log.info("Element, '" + element.getText().trim() + "' is not present in the application");
			WebElementWrappers.Reporter(driver,
					"Verify presence of element,Element " + element.getText().trim() + " should be present on the page,"
							+ "Element " + element.getText().trim() + " presence is not verified ,Fail");
			Assert.assertTrue(false);
		}
	}

	public static void assertElementPresentCompareText(WebElement element, String expectedText) {
		if (element.isDisplayed()) {
			log.info("Element, '" + element.getText().trim() + "' is present in the application");
			if (element.getText().trim().equalsIgnoreCase(expectedText)) {
				log.info("Expected and actual vaues are same : " + expectedText);
				Assert.assertTrue(true);
			} else {
				log.info("Expected and actual vaues are not same. Value in application is " + element.getText().trim());
				Assert.assertTrue(false);
			}
		} else {
			log.info("Element, '" + element.getText().trim() + "' is not present in the application");
			Assert.assertTrue(false);
		}
	}

	public static void selectDropdownByOptions(WebDriver driver, WebElement drpElement, String optionValue) {
		clickElement(driver, drpElement);
		List<WebElement> options = drpElement.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (option.getText().trim().equalsIgnoreCase(optionValue)) {
				option.click();

			}
		}
	}

	public static void clearandEnterinputValuetoDropdown(WebDriver driver, WebElement element, String value)
			throws InterruptedException {

		clickElement(driver, element);
		
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.BACK_SPACE);
		enterText(element, value);
		element.sendKeys(Keys.TAB);

	}

	public static void enterinputValuetoDropdown(WebElement element, String value) throws InterruptedException {

		clickElement(null, element);
		enterText(element, value);
		element.sendKeys(Keys.TAB);

	}

	public static void validateDropdown(WebDriver driver, WebElement drpElement, String optionValue) {
		Actions act = new Actions(driver);
		act.moveToElement(drpElement).click().perform();
		WebElementWrappers.clickElement(driver, getDynamicDrpDwn(driver, optionValue));

		log.info(drpElement.getText());
		if (drpElement.getText().equalsIgnoreCase(optionValue)) {
			log.info("User is able to select dropdown value as " + optionValue);
			Assert.assertTrue(true);
		} else {
			log.info("User is able not able to select dropdown value" + optionValue);
			Assert.assertTrue(false);
		}
	}

	public static void selectDropdowns(WebDriver driver, WebElement element, String value) throws InterruptedException {
		WebElementWrappers.clickByJs(driver, element);
		Thread.sleep(2000);
		element.sendKeys(Keys.ENTER);
		WebElement element1 = driver.findElement(By.xpath("//ul//li[text()='" + value + "']"));
		System.out.println(element1);
		WebElementWrappers.clickByJs(driver, element1);
	}

	public static void selectDropdownElement(WebDriver driver, WebElement element, String value)
			throws InterruptedException {
		WebElementWrappers.clickByJs(driver, element);
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("//ul//li[text()='" + value + "']"));
		System.out.println(element1);
		WebElementWrappers.clickByJs(driver, element1);
		Thread.sleep(2000);
	}

	public static void selectDropdownElementByRobot(WebDriver driver, WebElement element, String value)
			throws InterruptedException, AWTException {
		WebElementWrappers.clickByJs(driver, element);
		Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_ENTER);
		// element.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement element1 = driver.findElement(By.xpath("//ul//li[text()='" + value + "']"));
		System.out.println(element1);
		WebElementWrappers.clickByJs(driver, element1);
		// element.sendKeys(Keys.TAB);
	}

	public static void selectDropdown(WebDriver driver, WebElement drpElement, String optionValue) {
		Actions act = new Actions(driver);
		act.moveToElement(drpElement).click().perform();
		WebElementWrappers.clickElement(driver, getDynamicDrpDwn(driver, optionValue));
		act.sendKeys(Keys.ENTER);
	}

	public static WebElement getDynamicDrpDwn(WebDriver driver, String value) {
		return driver.findElement(By.xpath("//ul//li/span[text()='" + value + "']"));
	}

	public static void validateElementAbsence(WebElement element) {
		if (!element.isDisplayed()) {
			log.info("Element is not displayed in the application");
			Assert.assertTrue("Element is not displayed in the application", true);
		} else {
			log.info("Element is displayed in the application");
			Assert.assertTrue("Element is displayed in the application", false);
		}
	}

	public static void validateElementPresence(WebElement element) {
		if (element.isDisplayed()) {
			log.info("Element is displayed in the application");
			Assert.assertTrue("Element is displayed in the application", true);
		} else {
			log.info("Element is not displayed in the application");
			Assert.assertTrue("Element is not displayed in the application", false);
		}
	}

	public static void verifyElementDisabled(WebElement element) {
		if (!element.isEnabled()) {
			log.info("Element is disabled in the application");
			Assert.assertTrue("Element is disabled in the application", true);
		} else {
			log.info("Element is not disabled in the application");
			Assert.assertTrue("Element is not disabled in the application", false);
		}
	}

	public static void verifyElementDisabledAttribute(WebElement element, String attribute) {
		if (attribute.contains("disabled")) {
			if (element.getAttribute(attribute).toLowerCase().contains("true")) {
				log.info("Element is disabled in the application, disabled attribute value :"
						+ element.getAttribute(attribute));
				Assert.assertTrue("Element is disabled in the application", true);
			} else {
				log.info("Element is not disabled in the application, disabled attribute value :"
						+ element.getAttribute(attribute));
				Assert.assertTrue("Element is not disabled in the application", false);
			}
		} else {
			if (element.getAttribute(attribute).toLowerCase().contains("disabled")) {
				log.info("Element is disabled in the application, disabled attribute value :"
						+ element.getAttribute(attribute));
				Assert.assertTrue("Element is disabled in the application", true);
			} else {
				log.info("Element is not disabled in the application, disabled attribute value :"
						+ element.getAttribute(attribute));
				Assert.assertTrue("Element is not disabled in the application", false);
			}
		}
	}

	public static void verifyElementSelected(WebElement element) {
		if (!element.isSelected()) {
			log.info("Element is selected in the application");
			Assert.assertTrue("Element is selected in the application", true);
		} else {
			log.info("Element is not selected in the application");
			Assert.assertTrue("Element is not selected in the application", false);
		}
	}

	public static void clickElementIfPresent(WebDriver driver, WebElement element) {
		if (element.isDisplayed()) {
			clickElement(driver, element);

			String pageLoadStatus = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");

			System.out.print(".");

			while (!pageLoadStatus.equals("complete"))
				;

			System.out.println();

			System.out.println("Page Loaded.");
			log.info("Element is displayed in the application");
		} else {
			log.info("Element is not displayed in the application");
		}
	}

	public static void ScrollToViewElementActionClass(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void validateElementPresenceWithSpecificMsg(WebElement element, String msg) {
		if (element.isDisplayed()) {
			log.info(msg + " is displayed in the application");
			Assert.assertTrue(msg + " is displayed in the application", true);
		} else {
			log.info(msg + " is not displayed in the application");
			Assert.assertTrue(msg + " is not displayed in the application", false);
		}
	}

	public static boolean retryingToClick(WebDriver driver, WebElement element) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 7) {
			try {
				WebElementWrappers.clickElement(driver, element);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			} catch (NoSuchElementException e) {

			}
			attempts++;
		}
		return result;
	}

	public static void deleteExistingFiles(String path) {
		for (File file : new File(path).listFiles()) {
			file.delete();
		}
		new File(path).delete();
	}

	public static void navigateToNewWindow(WebDriver driver, String title) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String win : windowHandles) {
			driver.switchTo().window(win);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	public static void waitPageLoad() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String storePdfDocument(String url1) throws Exception {

		URL url = new URL(url1);
		InputStream is = url.openStream();
		BufferedInputStream fileToParse = new BufferedInputStream(is);
		PDDocument document = null;
		document = PDDocument.load(fileToParse);
		int numberOfPages = getPageCount(document);
		String pdfContent = new PDFTextStripper().getText(document);
		document.close();
		return pdfContent;

	}

	public static int getPageCount(PDDocument doc) {
		int pageCount = doc.getNumberOfPages();
		return pageCount;
	}

	public static void enterKeys(WebElement element, Keys keys) {

		element.sendKeys(keys);
	}

	public static XSSFSheet readExcel(String filePath, String sheet) {

		XSSFSheet irpSheet = null;
		File strFilePath = new File(filePath);
		try (FileInputStream inputStream1 = new FileInputStream(strFilePath)) {

			XSSFWorkbook worktbook = new XSSFWorkbook(inputStream1);
			irpSheet = worktbook.getSheet(sheet);
			worktbook.close();
			return irpSheet;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return irpSheet;
	}

	public static int getRowNumber(String cellContent, XSSFSheet sheet) {
		int rowNum = 0;
		try {
			int rowCount1 = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (int i = 0; i <= rowCount1; i++) {
				Row row1 = sheet.getRow(i);
				if (!(row1 == null) && !(row1.getCell(0) == null) && !(row1.getCell(0).getCellType() == CellType.BLANK)
						&& row1.getCell(0).getCellType() == CellType.STRING
						&& row1.getCell(0).getStringCellValue().trim().equalsIgnoreCase(cellContent.trim())) {
					rowNum = row1.getRowNum();
					return rowNum + 1;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rowNum;

	}

	public static int getRowNumber(String testnamecellContent, XSSFSheet sheet, String cellContent) {
		int rowNum = 0;
		try {
			int rowCount1 = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (int i = 0; i <= rowCount1; i++) {
				Row row1 = sheet.getRow(i);
				if (!(row1 == null) && !(row1.getCell(0) == null) && !(row1.getCell(0).getCellType() == CellType.BLANK)
						&& row1.getCell(0).getCellType() == CellType.STRING
						&& row1.getCell(0).getStringCellValue().trim().equalsIgnoreCase(testnamecellContent.trim())
						&& row1.getCell(5).getStringCellValue().trim().equalsIgnoreCase(cellContent.trim())) {
					rowNum = row1.getRowNum();
					return rowNum + 1;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rowNum;

	}

	/*
	 * @description : Capture the screen short and create a folder screenshot
	 * 
	 * @param :
	 * 
	 * @return :
	 * 
	 * @date : 28 Dec 2020
	 * 
	 *
	 */
	/*
	 * public static String captureScreenshotReporter(WebDriver driver) { String
	 * extentScreenshot = null; LocalDateTime myDateObj = LocalDateTime.now();
	 * DateTimeFormatter myFormatObj =
	 * DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); String formattedDate =
	 * myDateObj.format(myFormatObj); formattedDate = formattedDate.replace(":",
	 * "").replace(" ", "");
	 * 
	 * try {
	 * 
	 * Capture the screenshots File sourceFile = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * String destinationPath = System.getProperty("user.dir") +
	 * "\\test-output\\results\\screenshots\\LatestResults\\"+WebDriverManagers.
	 * testcasename; File f1 = new File (destinationPath); if (!(f1.exists() &&
	 * f1.isDirectory())) { System.out.println("File created somewhere" + f1); new
	 * File(destinationPath).mkdirs(); }
	 * 
	 * String destination = destinationPath
	 * +"\\" + WebDriverManagers.methodname + formattedDate + ".png"; File
	 * destinationFile = new File(destination);
	 * 
	 * Copy the screen shot to target file FileUtils.copyFile(sourceFile,
	 * destinationFile); extentScreenshot = WebDriverManagers.methodname +
	 * formattedDate + ".png"; // System.out.println("copy"); return
	 * extentScreenshot; } catch (Exception e) { e.printStackTrace(); return null; }
	 * }
	 */

	
	public static String captureScreenshotReporter(WebDriver driver) {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");
		String formattedDate = myDateObj.format(myFormatObj);

		String sFileName = WebDriverManagers.methodname + formattedDate + ".png";
		try {
			File file = new File("test-output" + Seperator + "results" + Seperator + "screenshots" + Seperator
					+ "LatestResults" + Seperator + WebDriverManagers.testcasename);
			if (!file.exists()) {
				System.out.println("File created somewhere" + file);
				file.mkdir();
			}
			// Capture the screenshots
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File("test-output" + Seperator + "results" + Seperator + "screenshots" + Seperator
					+ "LatestResults" + Seperator + WebDriverManagers.testcasename, sFileName);
			FileUtils.copyFile(sourceFile, targetFile);
			// System.out.println("copy");
			return sFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//driver.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotpath)).setFullPage(true);

	/*
	 * @description : Method for reporter log
	 * 
	 * @param :WebDriver driver,String strReportLog
	 * 
	 * @return :NA
	 * 
	 * @date : 28 Dec 2020
	 * 
	 *
	 */

	public static void Reporter(WebDriver driver, String strReportLog) {
		boolean takescreenshot = false;
		String inputGlobalSheetName = FileReaderManager.getInstance().getConfigReader().getExcelGlobalSheetNameDA();
		String strScreenshotStatus = Xlsx_FileReader.excelreader.getCellData(inputGlobalSheetName, "Screenshot", 2);
		if (strScreenshotStatus.trim().equalsIgnoreCase("Yes")) {
			takescreenshot = true;
		}

		String imagePathInHost = "file:results" + Seperator + "screenshots" + Seperator + "LatestResults" + Seperator
				+ WebDriverManagers.testcasename + Seperator + WebElementWrappers.captureScreenshotReporter(driver);
		// String
		// imagePathInHost="file:///"+WebElementWrappers.captureScreenshotReporter(driver);
		String[] strArr = strReportLog.split(",");
		String strStatus = "";
		if (strArr[3].toLowerCase().trim().contains("Pass".toLowerCase().trim())) {
			if (takescreenshot == false) {
				strStatus = "<a style=\"font-weight: bold;color: green;\"> Pass </a>";
			} else {
				strStatus = "<a style=\"font-weight: bold;color: green;\" href=" + imagePathInHost + "> Pass </a>";
			}
			strArr[3] = strStatus;
		} else {
			strStatus = "<a style=\"font-weight: bold;color: red;\" href=" + imagePathInHost + "> Fail </a>";
			strArr[3] = strStatus;
		}

		/* Get all values with comma seperated */
		String strJoined = String.join(",", strArr);
		Reporter.log(strJoined);
	}

	/*
	 * @description : Method for reporter log
	 * 
	 * @param :WebDriver driver,String strReportLog
	 * 
	 * @return :NA
	 * 
	 * @date : 28 Dec 2020
	 * 
	 *
	 */

	public static void ReporterNoScreenshot(WebDriver driver, String strReportLog) {
		String imagePathInHost = "file:results" + Seperator + "screenshots" + Seperator + "LatestResults" + Seperator
				+ WebDriverManagers.testcasename + Seperator + WebElementWrappers.captureScreenshotReporter(driver);
		// String
		// imagePathInHost="file:///"+WebElementWrappers.captureScreenshotReporter(driver);
		String[] strArr = strReportLog.split(",");
		String strStatus = "";
		if (strArr[3].toLowerCase().trim().contains("Pass".toLowerCase().trim())) {
			strStatus = "<a style=\"font-weight: bold;color: green;\"> Pass </a>";
			strArr[3] = strStatus;
		} else {
			strStatus = "<a style=\"font-weight: bold;color: red;\"  href=" + imagePathInHost + "> Fail </a>";
			strArr[3] = strStatus;
		}

		/* Get all values with comma seperated */
		String strJoined = String.join(",", strArr);
		Reporter.log(strJoined);
	}

	public static String todaysDateformat() {
		Date date = new Date();
		String dateFormat = "MMM dd,yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		log.info("Today is " + sdf.format(date));
		return sdf.format(date);
	}

	public static int getRowcountNumber(String cellContent, XSSFSheet sheet) {
		int rowNum = 0;
		int count = 0;
		try {
			int rowCount1 = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (int i = 0; i <= rowCount1; i++) {
				Row row1 = sheet.getRow(i);
				if (!(row1 == null) && !(row1.getCell(0) == null) && !(row1.getCell(0).getCellType() == CellType.BLANK)
						&& row1.getCell(0).getCellType() == CellType.STRING
						&& row1.getCell(0).getStringCellValue().trim().equalsIgnoreCase(cellContent.trim())) {
					rowNum = row1.getRowNum();
					rowNum = rowNum + 1;
					count = count + 1;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;

	}

	public static void Reporter1(WebDriver driver, String strReportLog) {
		String Seperator = System.getProperty("file.separator");
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		formattedDate = formattedDate.replace(":", "");

		String[] strArr = strReportLog.split(",");
		String strStatus = "";

		/* Get all values with comma seperated */
		String strJoined = String.join(",", strArr);
		Reporter.log(strJoined);
	}

	public static WebElement FindElementByXpath(WebDriver driver, String locators) {
		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement strLst = driver.findElement(By.xpath("" + locators + ""));
			return strLst;
		} catch (Exception e) {
			return null;
		} finally {
			driver.manage().timeouts().implicitlyWait(
					FileReaderManager.getInstance().getConfigReader().getCustomWait("ImplicitWait"), TimeUnit.SECONDS);
		}
	}

	public static List<WebElement> FindElementsByXpath(WebDriver driver, String locators) {
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			List<WebElement> strLst = driver.findElements(By.xpath("" + locators + ""));
			if (strLst != null) {
				if (strLst.isEmpty()) {
					return null;
				}
			}
			return strLst;
		} catch (Exception e) {
			return null;
		} finally {
			driver.manage().timeouts().implicitlyWait(
					FileReaderManager.getInstance().getConfigReader().getCustomWait("ImplicitWait"), TimeUnit.SECONDS);
		}
	}

	/*
	 * @description :This method will click on web element through action class
	 * 
	 * @param :driver,element
	 * 
	 * @return :
	 * 
	 * @date : 28 Dec 2020
	 * 
	 *
	 */

	public static void functionLoading(WebDriver driver) {
		try {
			/* Code to wait for page load */
			int count = 0;
			do {
				WebElement element2 = WebElementWrappers.FindElementByXpath(driver, "//*[@class='lds-spinner']");
				System.out.println("loading page  : " + element2);
				if (element2 == null) {
					break;
				} else {
					
					count++;
				}
			} while (count <= 5);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void yearAssertion(String yearString) {
		Pattern yearPattern = Pattern.compile("\\b(19|20\\d{2}\\b");
		Matcher matcher = yearPattern.matcher(yearString);
		if (matcher.find()) {
			System.out.println("The displayed string is a year.");
		} else {
			System.out.println("The displayed string is not a year.");
		}
	}

	public static void numberAssertion(String numberString) {
		Pattern numberPattern = Pattern.compile("^\\d+(\\.\\d+)?$");
		Matcher matcher = numberPattern.matcher(numberString);
		if (matcher.find()) {
			System.out.println("The displayed string is a number.");
		} else {
			System.out.println("The displayed string is not a number.");
		}
	}

	public static boolean isElementExists(WebElement element) {
		boolean isPresent = false;
		try {
			if (element.isDisplayed()) {
				log.info("Element Exists");
				isPresent = true;
			}
		} catch (Exception e) {

			log.info("No Such Element Exists");

			isPresent = false;
		}
		return isPresent;
	}

	public static void zoomInBrowser(WebDriver driver) {
		System.out.println("Entered Zoomin");
		js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='90%'");
		System.out.println("Exit Zoomin");

	}
}
