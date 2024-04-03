package com.wbg.selenium.qa.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.log4j.Logger;
//import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;


import com.wbg.selenium.qa.manager.WebDriverManagers;
import com.wbg.selenium.qa.utils.LoggerHelper;
import com.wbg.selenium.qa.utils.WebElementWrappers;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetAPIData extends WebDriverManagers{
	Logger log = LoggerHelper.getLogger(GetAPIData.class);
	String Seperator = System.getProperty("file.separator"); 

	public void fetchServiceData(String baseuri,String strFileName,String strLevelUri) {
		try {
		
			/* code for authentication */
			PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		
			authScheme.setUserName("SRV-REPCOMPREAD@ifcad.ifc.org");
			authScheme.setPassword("th;sisC1T0ps^d_t_HuB3erVIce9?6c[0]UnT$z");
			RestAssured.authentication = authScheme;

			RestAssured.baseURI = baseuri;
			RequestSpecification httpRequest = RestAssured.given();
		
			Response response = httpRequest.get(strLevelUri);
			
		Thread.sleep(2000);
			/*
			 * Get the status line from the Response and store it in a variable called
			 * statusLine
			 */
			String statusLine = response.getStatusLine();
			System.out.println(statusLine);
			System.out.println(response.getBody().asString());
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status code returned");

			/* Get data in json format */
			String jsonString = response.body().asString();
			
			String strModifiedJson= "{\"value\""+jsonString.split("value\"")[1];

			/* Write data inside file */
			// String filePath = "src/test/resources/APIData" + "/APIData.txt";
			String filePath = "src" + Seperator + "test" + Seperator + "resources" + Seperator + "APIData" + Seperator+ testcasename+Seperator
					+ strFileName;
			File file = new File(filePath);
			
		
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
			FileWriter fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(strModifiedJson);
			bufferedWriter.newLine();
			bufferedWriter.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			WebElementWrappers.Reporter(driver, "Request to fetch the Service data, Service data should be fetched, Requested service data is not fetched , Fail");
			Assert.fail();
		}
	}
	
	public Input getAPIDataInstance(String filePath) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			Input obj = mapper.readValue(new File(filePath), Input.class);
			return obj;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
