package com.rakesh.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.rakesh.Base.TestBase;

public class Utilities extends TestBase {
	
	@DataProvider(name = "dp")
	public Object[] dataProviderMethod(Method m) throws Exception {
		
		Object[] obj = new Object[1];
		TestDataHolder data = new TestDataHolder();
		
		String testCaseName = m.getName();
		data = excel.getExcelDataForTestCaseName(testCaseName);
		
		obj[0] = data;
		return obj;
		
	}

}
