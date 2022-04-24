package PracticeMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MYSQL_DB {

	public static void main(String[] args) throws SQLException {
		
		// step 1: Register/load Mysql database 
		Driver db = new Driver();
		DriverManager.registerDriver(db);
		
		//step 2: get connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","root");
		
		// Create SQL statement
		Statement st = con.createStatement();
		String  query = "select * from students_info";
		
		//step 4: Execute statement/Query
		 ResultSet result =st.executeQuery(query);
				
		 while(result.next()) {
			 
			 System.out.println(result.getInt(1)+ "\t" +result.getString(2)+ "\t" +result.getString(3)+ "\t" +result.getString(4));
		 }
		// step 5: close connection
		 con.close();
	}
}
