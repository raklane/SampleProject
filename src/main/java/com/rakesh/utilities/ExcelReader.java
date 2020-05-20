package com.rakesh.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelReader {

	private FileInputStream fis;
	private XSSFWorkbook wb;
	private XSSFSheet ws;
	private XSSFCell cell;

	public ExcelReader(String path) throws IOException {

		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheetAt(0);
		fis.close();

	}

	public TestDataHolder getExcelDataForTestCaseName(String testCaseName)
			throws Exception {

		TestDataHolder data = new TestDataHolder();

		for (int i = 1; i < getRowcount(); i++) {

			if (ws.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName)) {
				Method method;
				for (Field field : TestDataHolder.class.getDeclaredFields()) {
					String fieldName = field.getName();
					fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
					String fieldValue = getCellDataByColumnName(i, fieldName);
					method = TestDataHolder.class.getDeclaredMethod("set" + fieldName, String.class);
					method.invoke(data, fieldValue);
				}
				return data;
			}

		}
		Assert.fail("No data exists for this test case.");
		return data;

	}

	private int getColumnCount() {
		return ws.getRow(0).getLastCellNum();
	}

	private int getRowcount() {
		return ws.getLastRowNum() + 1;
	}

	private String getCellDataByColumnName(int row, String colName) {

		for (int i = 1; i < getColumnCount(); i++) {
			if (ws.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
				cell = ws.getRow(row).getCell(i);
				if(cell.getCellType() == cell.CELL_TYPE_STRING) {
					return cell.getStringCellValue();
				}else
					return String.valueOf((int)cell.getNumericCellValue());
			}
		}

		return "";
	}

}
