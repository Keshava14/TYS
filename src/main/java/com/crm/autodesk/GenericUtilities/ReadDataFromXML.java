package com.crm.autodesk.GenericUtilities;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXML extends BaseClass {

	@Test
	public void readFromXML(XmlTest xmlobj) {
		
		System.out.println(xmlobj.getParameter("browser"));
	
	}
}
