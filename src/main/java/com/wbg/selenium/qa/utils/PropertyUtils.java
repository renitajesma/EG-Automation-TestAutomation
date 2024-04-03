package com.wbg.selenium.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tnfb.constants.FrameworkConstants;
import com.tnfb.enums.ConfigProperties;
import com.tnfb.exceptions.InvalidpathForPropertyFileException;

public class PropertyUtils {

	private static Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP=new HashMap();

	private PropertyUtils() {

	}

	static {
		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
			
			property.load(fis);
			
			for(Map.Entry<Object, Object> entry: property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		
			//Same above code using java8 lambda
			//property.entrySet().forEach(entry->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Objects.isNull(property.get(key)) ||
	
	public static String get(ConfigProperties key)  {
		if (Objects.isNull(key) ||Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new InvalidpathForPropertyFileException("Property name " + key + " not found please check property file");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
	
}
