package PracticeMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class ReadDataFrom_SQL_Select {

			public static void main(String[] args) throws SQLException {
				
				// step 1: Register/load Mysql database 
				OracleDriver o = new OracleDriver();
				DriverManager.registerDriver(o);
				
				//step 2: get connect to database
				Connection con = DriverManager.getConnection
						("jdbc:oracle:thin:@localhost:1521/Empolyes","scott","tiger");
				
				// Create SQL statement
				Statement st = con.createStatement();
				String  query = "select * from emp";
				
				//step 4: Execute statement/Query
				ResultSet result =st.executeQuery(query);
				
				 while(result.next()) {
					 System.out.println(result.getInt(1)+ "\t" +result.getString(2)+ "\t" +result.getString(3)+ "\t" +result.getInt(4));
				 }
				 // step 5: close connection
				 con.close();
			}
		}
