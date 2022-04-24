package com.test.practice;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.crm.autodesk.GenericUtilities.JSON_FileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;

public class DemoFileReader {
	
public static void main(String[] args) throws IOException, ParseException {
	
	JSON_FileUtility jsf = new JSON_FileUtility();
	
	JavaUtility ju = new JavaUtility();
	
	System.out.println(jsf.readDataFromJSON("url"));
	System.out.println(jsf.readDataFromJSON("browser"));
	System.out.println(jsf.readDataFromJSON("username"));
	System.out.println(jsf.readDataFromJSON("password"));
	
	System.out.println(ju.getRandomNum());

	}
}
