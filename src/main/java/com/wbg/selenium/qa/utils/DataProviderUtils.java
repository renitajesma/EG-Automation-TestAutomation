package com.wbg.selenium.qa.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.tnfb.constants.FrameworkConstants;
/**
 * 
 * @author G N Reddy
 * 
 * This class getData method reads test data from excel based on test case dynamically and stores 
 * test data in Map and Map will be stored in List
 *
 */
public class DataProviderUtils {

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider(parallel=true)
	public Object[] getData(Method m) {
		String testname = m.getName();

		if (list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
		}
		List<Map<String, String>> singletclist = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testname").equalsIgnoreCase(testname)
					&& list.get(i).get("execute").equalsIgnoreCase("yes")) {
				singletclist.add(list.get(i));
			}
		}
	
		return singletclist.toArray();
	}
}
