package com.test.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CompareXLSFiles {

	public static void main(String[] args) throws IOException {
		FileInputStream fis1 = new FileInputStream(new File(".//testdata//location1/LoginTestData1.xls"));
		HSSFWorkbook wb1 = new HSSFWorkbook(fis1);
		HSSFSheet sheet1 = wb1.getSheetAt(0);

		FileInputStream fis2 = new FileInputStream(new File(".//testdata//location2/LoginTestData2.xls"));
		HSSFWorkbook wb2 = new HSSFWorkbook(fis2);
		HSSFSheet sheet2 = wb2.getSheetAt(0);

		if (sheet1.getLastRowNum() == sheet2.getLastRowNum()) {
			Row rowOneOfFileOne = sheet1.getRow(0);
			Row rowTwoOfFileTwo = sheet2.getRow(0);
			if (rowOneOfFileOne.getLastCellNum() == rowTwoOfFileTwo.getLastCellNum()) {
				for (int i = 0; i <= sheet2.getLastRowNum(); i++) {
					Row rowOfFileOne = sheet1.getRow(i);
					Row rowOfFileTwo = sheet2.getRow(i);
					String cellVal1 = "";
					String cellVal2 = "";
					for (int j = 0; j < rowOneOfFileOne.getLastCellNum(); j++) {
						Cell cell1 = rowOfFileOne.getCell(j);
						cellVal1 = getCellValue(cell1);
						Cell cell2 = rowOfFileTwo.getCell(j);
						cellVal2 = getCellValue(cell2);
						if (!cellVal1.contentEquals(cellVal2)) {
							System.out.println("Values in cell '" + getCellAddress(i, j) + "' do not match");
						}
					}
				}
			} else {
				System.out.println("Files having different no of columns.");
			}
		} else {
			System.out.println("Files having different no of rows.");
		}

	}

	public static String getCellValue(Cell cellType) {
		String cellValue = "";
		if (cellType != null) {
			switch (cellType.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				cellValue = cellType.toString();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				// cellValue = convertNumericCelltoString(cellType).toString();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				boolean cellVal = cellType.getBooleanCellValue();
				cellValue = new Boolean(cellVal).toString();
				break;
			case Cell.CELL_TYPE_FORMULA:
				cellValue = cellType.getStringCellValue();
				break;
			default:
			}
		}
		return cellValue.trim();
	}

	private static String getCellAddress(int row, int col) {
		String address = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		char[] alphaArray = alphabet.toCharArray();
		int firstCharPosition = col / 26;
		int secCharPosition = col % 26;
		address = Character.toString(alphaArray[firstCharPosition-1]).toUpperCase()
				+ Character.toString(alphaArray[secCharPosition]).toUpperCase() + Integer.toString(row+1);
		return address;

	}

}
