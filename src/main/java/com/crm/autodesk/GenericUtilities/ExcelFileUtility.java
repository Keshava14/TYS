package com.crm.autodesk.GenericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * The class contains generic methods to read and write data from excel sheet
 * @author Keshava
 *
 */
public class ExcelFileUtility {
		/**
		 * This method will read specific data from excel sheet
		 * @param sheetName
		 * @param rownum
		 * @param cellnum
		 * @return value
		 * @throws Throwable 
		 */
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh =book.getSheet(sheetName);
		//Row row = sh.getRow(rownum);
		// Cell  cell = row.getCell(cellnum);
		//String Value = cell.getStringCellValue();
		DataFormatter format = new DataFormatter();		
		String value = format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		return value;						
	}
	
	/**
	 * this method return the all data from sheet
	 * @param sheetname
	 * @return data
	 * @throws Throwable
	 */
	public Object[][] getExcelData(String sheetname) throws  Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelFilePath);
		Workbook book = WorkbookFactory.create(fis);  
		Sheet sh =book.getSheet(sheetname);
		
		int lastRow = sh.getLastRowNum();
		int lastCell =sh.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{	
				data [i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}	
}
