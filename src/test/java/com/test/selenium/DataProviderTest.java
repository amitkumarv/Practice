package com.test.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	/**
	 * Description : Read a cell value from the excel sheet and if the cell value is numeric then convert it to string 
	 * @param columnValue
	 * @return strValue
	 */
	private static String convertNumericCelltoString(Cell columnValue) {
		String strValue = "";
		if (columnValue != null) {
			double cellVal = columnValue.getNumericCellValue();
			BigDecimal big = new BigDecimal(cellVal);
			strValue = String.valueOf(big);
			if (strValue.contains(".")) {
				double val = Double.valueOf(strValue).doubleValue();
				strValue = String.valueOf(val);
				if (strValue.endsWith("0"))
					strValue = strValue.substring(0, strValue.length() - 1);
			}
		}
		return strValue;
	}

	public ArrayList<Object[]> readDataFromExcel() throws FileNotFoundException, IOException {
		ArrayList<Object[]> al = new ArrayList<>();
		
		XSSFWorkbook xssfWorkBook = new XSSFWorkbook(new FileInputStream(new File(".\\testdata\\Customers.xlsx")));
		XSSFSheet firstSheet = xssfWorkBook.getSheetAt(0);
		for (int i = 1; i <= firstSheet.getLastRowNum(); i++) {
			XSSFRow row = firstSheet.getRow(i);
			String fname = row.getCell(0).getStringCellValue();
			String lname = row.getCell(1).getStringCellValue();
			String email = row.getCell(2).getStringCellValue();
			String contact = Integer.toString((int) row.getCell(3).getNumericCellValue());
			String zip = Integer.toString((int) row.getCell(4).getNumericCellValue());
			al.add(new Object[] {fname, lname, email, contact, zip});
		}
		return al;
	}
	
	
	@DataProvider
	public Iterator<Object[]> getData() throws FileNotFoundException, IOException {
		ArrayList<Object[]> al = readDataFromExcel();
		return al.iterator();
	}
	
	
	@Test(dataProvider="getData")
	public void sampleTest(String fname, String lname, String email, String contact, String zip) throws FileNotFoundException, IOException {

		System.out.println(fname + ", " + lname + ", " + email + ", " + contact + ", " + zip);
	}
}
