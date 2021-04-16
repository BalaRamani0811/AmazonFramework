package com.mindtree.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static Object[][] readExcel() {
		Object[][] search = null;
		XSSFWorkbook book;
		try {
			book = new XSSFWorkbook("C:\\TestNGSelenium\\AmazonFramework\\test-data\\Amazon.xlsx");
			XSSFSheet sheet = book.getSheet("Login");
			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			search = new Object[rowCount - 1][colCount];
			for (int i = 1; i < rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					String searchData = sheet.getRow(i).getCell(j).getStringCellValue();
					search[i - 1][j] = searchData;
				}
			}
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return search;
	}

	public static List<String> getItems() {

		List<String> items = new ArrayList<String>();
		XSSFWorkbook book = null;
		try {
			book = new XSSFWorkbook("C:\\TestNGSelenium\\AmazonFramework\\test-data\\Amazon.xlsx");
			XSSFSheet sheet = book.getSheet("Item");
			int rowCount = sheet.getLastRowNum();
			for (int i = 0; i <= rowCount; i++) {
				String searchData = sheet.getRow(i).getCell(0).getStringCellValue();
				items.add(searchData);
			}
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
}
