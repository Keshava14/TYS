package com.com.autodesk.Contacts.Tests;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excel {

	public String getExcelData(String sheetname, int rownum, int cellnum ) throws  Throwable
	{
		FileInputStream fis = new FileInputStream
				("C:\\Users\\USER\\OneDrive\\Documents\\DataStorageFile\\Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		return value;
	}	

}
