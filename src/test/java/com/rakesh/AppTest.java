package com.rakesh;

import org.testng.annotations.Test;

import com.rakesh.Base.TestBase;
import com.rakesh.utilities.TestDataHolder;
import com.rakesh.utilities.Utilities;

public class AppTest extends TestBase{
	
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void sampleTestCase1(TestDataHolder data) {
		
		System.out.println("-----Inside sampleTestCase1");
		System.out.println(data.getFirstName());
		System.out.println(data.getLastName());
		System.out.println(data.getEmployeeNumber());
		
	}
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void sampleTestCase4(TestDataHolder data) {
		
		System.out.println("-----Inside sampleTestCase2");
		System.out.println(data.getFirstName());
		System.out.println(data.getLastName());
		System.out.println(data.getEmployeeNumber());
		
	}
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void sampleTestCase2(TestDataHolder data) {
		
		System.out.println("-----Inside sampleTestCase3");
		System.out.println(data.getFirstName());
		System.out.println(data.getLastName());
		System.out.println(data.getEmployeeNumber());
		
	}
	
}
