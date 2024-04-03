package com.wbg.selenium.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tnfb.constants.FrameworkConstants;
import com.tnfb.exceptions.FrameworkException;
/**
 * 
 * @author G N Reddy
 * 
 * This class getTest Details method gets test data from excel in the from of List<Map<String,String>> 
 *
 */
public final class ExcelUtils {

	private ExcelUtils() {}

	public static List<Map<String, String>> getTestDetails(String sheetname) {
		
		List<Map<String, String>> list = null;
		try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath())) {
			
			XSSFWorkbook workbook = new XSSFWorkbook(fs);

			XSSFSheet sheet = workbook.getSheet(sheetname);

			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();

			Map<String, String> map = null;
			list = new ArrayList();

			for (int i = 1; i <= lastrownum; i++) {
				map = new HashMap();
				for (int j = 0; j < lastcolnum; j++) {
					
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
			throw new InvalidParameterException("Excel file you trying to read is not found");
		} catch (IOException e) {
			throw new FrameworkException("Some IO exception happened while reading excel");
		} 

		return list;
	}
	
public static void writeTestDetails(String sheetname,String tcName,String colName,String data) {
		int colNum=0;
		int rowNum=0;
		try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath())) {
			
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetname);

			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();
			
			for(int i=0;i<=lastrownum;i++) {
				
				if(sheet.getRow(i).getCell(0).toString().equals(tcName)) {
					rowNum=i;
				}
			}
			
			for (int i = 1; i <= lastrownum; i++) {
				
				for (int j = 0; j < lastcolnum; j++) {
					//System.out.println();
					if(sheet.getRow(0).getCell(j).toString().equals(colName)) {
						colNum=j;
					}
					
					
				}
				
			}

			sheet.getRow(rowNum).getCell(colNum).setCellValue(data);
			FileOutputStream out=new FileOutputStream(FrameworkConstants.getExcelpath());
			workbook.write(out);
			out.close();
			fs.close();
			
		} catch (FileNotFoundException e) {
			throw new InvalidParameterException("Excel file you trying to read is not found");
		} catch (IOException e) {
			throw new FrameworkException("Some IO exception happened while reading excel");
		} 

	}

	public static int getRandomNum() {
		Random rand = new Random();
		   
        // Generate random integers in range 0 to 999
        int rand_num = rand.nextInt(1000);
        return rand_num;
	}

public static List<Map<String, String>> getTestDetails1(String sheetname) {
		
		List<Map<String, String>> list = null;
		try(FileInputStream fs = new FileInputStream("C:\\AutomationWithLambda\\Winapp\\Automation Test cases for Access User Story.xlsx")) {
			
			XSSFWorkbook workbook = new XSSFWorkbook(fs);

			XSSFSheet sheet = workbook.getSheet(sheetname);

			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();

			Map<String, String> map = null;
			list = new ArrayList();

			for (int i = 1; i <= lastrownum; i++) {
				map = new HashMap();
				for (int j = 0; j < lastcolnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
			throw new InvalidParameterException("Excel file you trying to read is not found");
		} catch (IOException e) {
			throw new FrameworkException("Some IO exception happened while reading excel");
		} 

		return list;
	}
	

public static void main(String[] args) 
{
	System.out.println(getTestDetails("DATA"));;
	
}
	
}
