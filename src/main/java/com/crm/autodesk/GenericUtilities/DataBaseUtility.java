package com.crm.autodesk.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;


/**
 * This class contains generic methods to read data from DataBaseUtility
 * @author Keshava
 *
 */
public class DataBaseUtility {

	Driver driverRef;
	Connection con =null;

	/**
	 * @throws Throwable 
	 * 
	 */
	public void connectToDB() throws Throwable{
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbUsername,IPathConstants.dbPassword);
	}

	/**
	 * 
	 * @throws Throwable
	 */
	public void getDataFromDb() throws Throwable {
		String query = null;
		ResultSet result = con.createStatement().executeQuery(query);

	}

	/**
	 * @throws Throwable 
	 * 
	 */
	public void closeDb() throws Throwable {
		con.close();
	}

}
