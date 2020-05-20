package com.rakesh.Base;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import com.rakesh.utilities.ExcelReader;

public class TestBase {
	
	public static ExcelReader excel;
	
	@BeforeSuite()
	public void setUp() throws IOException {
		
		excel = new ExcelReader("/Users/rakeshkumar/eclipse-workspace/SampleProject/src/test/resources/data/TestData.xlsx");
		
	}

}
