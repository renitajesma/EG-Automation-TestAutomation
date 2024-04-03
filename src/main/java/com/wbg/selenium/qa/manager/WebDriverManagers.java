package com.wbg.selenium.qa.manager;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.wbg.selenium.qa.configReader.Common_XlsxReader;
import com.wbg.selenium.qa.configReader.Xlsx_FileReader;
import com.wbg.selenium.qa.enums.Browser;
import com.wbg.selenium.qa.pageobject.LoginPageobject;
import com.wbg.selenium.qa.services.GetAPIData;
import com.wbg.selenium.qa.utils.WebElementWrappers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagers {
	public static WebDriver driver;
	private static Browser browser;
	private static final String edge_Browser_property = "webdriver.edge.driver";
	private static final String chrome_Browser_property = "webdriver.chrome.driver";
	private static final String firefox_Browser_property = "webdriver.gecko.driver";
	private static final String IE_Browser_property = "webdriver.ie.driver";
	public String Seperator = System.getProperty("file.separator");
	private static HashMap<String, WebDriver> driverObjMap = new HashMap<String, WebDriver>();
	private static String browserName;
	public static String methodname;
	public static String testcasename;
	private XSSFSheet strInputSheetdata;

	public WebDriverManagers() {

		browser = FileReaderManager.getInstance().getConfigReader().getBrowser();

	}

	@BeforeTest
	public void excel() throws Exception {
		String inputGlobalSheet = FileReaderManager.getInstance().getConfigReader().getExcelGlobalSheetNameDA();
		LoginPageobject loginPage = new LoginPageobject();
		String inputSheetName = FileReaderManager.getInstance().getConfigReader().getInputSheetNameDA();
		String inputFilePath = FileReaderManager.getInstance().getConfigReader().getInputExcelPath();
		strInputSheetdata = WebElementWrappers.readExcel(inputFilePath, inputSheetName);
		int rowNum = WebElementWrappers.getRowNumber(this.getClass().getSimpleName(), strInputSheetdata);
		int rowNumGeneric = 2;
		createDriver();
		loginPage = PageFactory.initElements(driver, LoginPageobject.class);

		/*
		 * loginPage.loginDAApplication(Xlsx_FileReader.excelreader.getCellData(
		 * inputSheetName, "projectId", rowNum),
		 * Xlsx_FileReader.excelreader.getCellData(inputGlobalSheet, "emailId",
		 * rowNumGeneric), Xlsx_FileReader.excelreader.getCellData(inputGlobalSheet,
		 * "strUserName", rowNumGeneric),
		 * Xlsx_FileReader.excelreader.getCellData(inputGlobalSheet, "strPassword",
		 * rowNumGeneric)); WebElementWrappers.Reporter(
		 * driver,"Verify the login functionality,User should be logged into AIMM application successfully,User successfully logged into AIMM application,Pass"
		 * ); Assert.assertTrue(true, "User successfully logged into AIMM application");
		 */
	}

	public static WebDriver gerDriverDetails(String className) {
		return driverObjMap.get(className);
	}

	/*
	 * @description : Method to get the details of browser
	 * 
	 * @param :
	 * 
	 * @return : browser
	 * 
	 * @date : 28 Dec 2020
	 * 
	 *
	 */

	/*
	 * @description : Method to delete the exisiting download files
	 * 
	 * @param :
	 * 
	 * @return :
	 * 
	 * @date : 28 Dec 2020
	 * 
	 *
	 */

	public void deletefile() throws Exception {
		try {
			String filePath = "src" + Seperator + "test" + Seperator + "resources" + Seperator + "APIData" + Seperator
					+ getClass().getSimpleName();

			String filePath1 = System.getProperty("user.dir") + Seperator + "Downloads" + Seperator + "LatestResults"
					+ Seperator + getClass().getSimpleName();

			File file = new File(filePath1);
			if (file.exists()) {
				for (File f : file.listFiles()) {
					FileUtils.forceDelete(f);
				}
			}

			File file1 = new File(filePath);
			if (file1.exists()) {
				for (File f : file1.listFiles()) {
					FileUtils.forceDelete(f);
				}
			}
		} catch (Exception e) {

		}

	}

	/*
	 * @description : Method to create the driver
	 * 
	 * @param :
	 * 
	 * @return : WebDriver
	 * 
	 * @date : 28 Dec 2020
	 * 
	 *
	 */
	@BeforeTest
	public void getDriver() throws Exception {
		deletefile();
		testcasename = getClass().getSimpleName();

		// return createDriver();

	}
	/*
	 * @BeforeTest public void excelread() { String inputSheetName =
	 * FileReaderManager.getInstance().getConfigReader().getExcelSheetNameDA();
	 * String inputFilePath =
	 * FileReaderManager.getInstance().getConfigReader().getInputExcelPath();
	 * strInputSheetdata = WebElementWrappers.readExcel(inputFilePath,
	 * inputSheetName);
	 * 
	 * }
	 */

	/*
	 * @description : Method to call the delete the files method
	 * 
	 * @param :
	 * 
	 * @return : WebDriver
	 * 
	 * @date : 28 Dec 2020
	 * 
	 *
	 */
	/*
	 * @BeforeTest public void DeleteFiles() throws Exception { deletefile();
	 * 
	 * }
	 */

	@BeforeMethod
	public void beforeTestMethod(Method testMethod) {
		System.out.println("Before Testmethod: " + testMethod.getName());
		methodname = testMethod.getName();
	}

	/*
	 * @description : Method to create the driver
	 * 
	 * @param :
	 * 
	 * @return : WebDriver
	 * 
	 * @date : 28 Dec 2020
	 * 
	 *
	 */
	private WebDriver createDriver() {

		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:
			// WebDriverManager.chromedriver().setup();
			System.setProperty(chrome_Browser_property,
					FileReaderManager.getInstance().getConfigReader().getDriverPath());
			ChromeOptions options = new ChromeOptions();
		//	options.addArguments("--incognito");
			// options.addArguments("--headless");

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("--disable-gpu");
			// options.addArguments("--no-sandbox");
			
			ChromeOptions oc=new ChromeOptions();
			oc.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(oc);
			
			options.addArguments("--disable-extensions");
			// options.addArguments("--dns-prefetch-disable");

			// options.addArguments("--user-data-dir=C:\\Users\\naggarwal3\\OneDrive -
			// WBG\\Desktop\\User Data");
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();

			chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
			chromeOptionsMap.put("profile.default_content_settings.popups", 0);
			chromeOptionsMap.put("download.prompt_for_download", true);

			options.setExperimentalOption("prefs", chromeOptionsMap);

			chromeOptionsMap.put("download.default_directory", System.getProperty("user.dir") + Seperator + "Downloads"
					+ Seperator + "LatestResults" + Seperator + getClass().getSimpleName());

			options.setExperimentalOption("prefs", chromeOptionsMap);
			// options.setCapability(Capabilities, getClass().getSimpleName());
			driver = new ChromeDriver(options);
			driverObjMap.put(getClass().getName(), driver);
			break;
		case IE:
			System.setProperty(IE_Browser_property, FileReaderManager.getInstance().getConfigReader().getDriverPath());
			driver = new InternetExplorerDriver();
			break;

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(
				FileReaderManager.getInstance().getConfigReader().getCustomWait("ImplicitWait"), TimeUnit.SECONDS);
		return driver;

	}

	@AfterSuite
	public void closeDriver() {
		if (driver.getWindowHandle() != null) {
			// strInputSheetdata=null;
			driver.manage().deleteAllCookies();
//		driver.close();
			driver.quit();
			driverObjMap.clear();

		}

	}

}
