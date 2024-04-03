package com.tnfb.constants;

import com.tnfb.enums.ConfigProperties;
import com.wbg.selenium.qa.utils.PropertyUtils;


public class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String EDGEDRIVERPATH = RESOURCESPATH + "/executables/msedgedriver.exe";
	private static final String FIREFOXDRIVERPATH = RESOURCESPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final String CONFIGJSONFILEPATH = RESOURCESPATH + "/config/config.json";
	private static final String EXCELPATH = RESOURCESPATH + "/excel/Testdata.xlsx";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static String extentReportFilePath = "";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";
	private static final int EPLICITWAIT = 10;

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}

	public static String getExtentreportfilepath()  {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath()  {
		if (PropertyUtils.get(ConfigProperties.REPORTOVERRIDE).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
		} else {
			return EXTENTREPORTFOLDERPATH + "/index.html";
		}
	}

	public static String getEdgeDriverPath() {
		return EDGEDRIVERPATH;
	}

	public static String getFirefoxdriverpath() {
		return FIREFOXDRIVERPATH;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static int getExplicitWait() {
		return EPLICITWAIT;
	}

	public static String getJsonFilePath() {
		return CONFIGJSONFILEPATH;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(PropertyUtils.get(ConfigProperties.REPORTOVERRIDE) + " is");
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

}
