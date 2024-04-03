package com.wbg.selenium.qa.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;

public class CreateResultFolderStructure {
	String Seperator = System.getProperty("file.separator");

	/*
	 * @description : Method to Create folder structure
	 * 
	 * @param : NA
	 * 
	 * @return : strTestClassName,strTestDescription,CSIPID
	 * 
	 * @date : 27 Dec 2020
	 * 
	 *
	 */
	public String generateResultFolder(String strTestClassName, String strTestDescription, String CSIPID) {
		try {

			String PATH = "test-output/";
			List<String> pathList = new ArrayList<String>();
			pathList.add("results");
			pathList.add("outputfiles");
			pathList.add(strTestClassName);
			pathList.add(strTestDescription);
			pathList.add(CSIPID);
			String directoryName = new String();
			for (String string : pathList) {
				directoryName = PATH.concat(string);
				File directory = new File(directoryName);
				if (!directory.exists()) {
					directory.mkdir();
				}
				PATH = directoryName + "/";
			}
			return directoryName;

		} catch (Exception e) {
			Reporter.log("Verify that the functionality is failed, Functionality is failed, Functionality is failed : "
					+ e.getClass().getSimpleName() + " ,Fail");
			Assert.fail();
		}
		return null;
	}

	/*
	 * @description : Method to Create file
	 * 
	 * @param : NA
	 * 
	 * @return : strFilePath
	 * 
	 * @date : 27 Dec 2020
	 * 
	 *
	 */
	public static boolean createFile(String strFilePath) {
		File f = new File(strFilePath);
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
		} catch (Exception e) {
			Reporter.log("Verify that the functionality is failed, Functionality is failed, Functionality is failed : "
					+ e.getClass().getSimpleName() + " ,Fail");
			Assert.fail();
		}
		return f.exists();
	}
}
