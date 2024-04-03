package com.wbg.selenium.qa.configReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.wbg.selenium.qa.manager.FileReaderManager;

/*
 * @description : Class to load and read xlsx file
 * 
 * @param : NA
 * 
 * @return : NA
 * 
 * @date : 28 Dec 2020
 * 
 *
 */
public class Xlsx_FileReader {
	public static Common_XlsxReader excelreader;
	 public static String excelPath;
	public static Properties prop;
	public Xlsx_FileReader(){
		try { 
		
			
			excelPath=FileReaderManager.getInstance().getConfigReader().getInputExcelPath();

			excelreader = new Common_XlsxReader(excelPath);

		} catch (Exception e) {
			e.printStackTrace();
		
		}
}
}
