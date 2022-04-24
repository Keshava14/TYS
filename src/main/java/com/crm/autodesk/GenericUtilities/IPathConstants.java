package com.crm.autodesk.GenericUtilities;
/**
 * the Interface contains generic method to store all the data securly
 * @author Keshava
 *
 */
public interface IPathConstants {

	String PropertyFilePath ="./Datastorage/commonData.Properties";
	String ExcelFilePath ="./Datastorage/testdata.xlsx";
	String JSONFilePath ="./target/commonData.json";
	
	String dbURL="jdbc:mysql://localhost:3306/projects";
	String dbUsername ="root";
	String dbPassword ="root";
}
