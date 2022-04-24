package com.crm.autodesk.GenericUtilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** 
 *  * This class contain methods to read data from file
 * @author Keshava
 *
 */
public class JSON_FileUtility {

	/**
	 * this method reads data from json file
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws throws
	 */

	public String readDataFromJSON(String key) throws IOException, ParseException {
		//read the data from json file
		FileReader file = new FileReader(IPathConstants.JSONFilePath);

		//convert the json into java object
		JSONParser jsnobj = new JSONParser();
		Object obj = jsnobj.parse(file);

		//type cast java object to hashmap
		HashMap map =(HashMap)obj;
		String value= map.get(key).toString();

		//return the value
		return value;

	}
}