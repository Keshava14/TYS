package com.crm.autodesk.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains generic methods  to read data from PropertyFile
 * @author Keshava
 *
 */
public class PropertyFile {

	public String getPropertyFile(String key) throws Throwable {

		FileInputStream fis = new FileInputStream(IPathConstants.PropertyFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		 
		return value;
	}	
}
