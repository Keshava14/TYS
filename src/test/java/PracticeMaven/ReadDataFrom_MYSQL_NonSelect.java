package PracticeMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MYSQL_NonSelect {

		public static void main(String[] args) throws SQLException {
			
			// step 1: Register/load Mysql database 
			Driver db = new Driver();
			DriverManager.registerDriver(db);
			
			//step 2: get connect to database
			Connection con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/students","root","root");
			
			// Create SQL statement
			Statement st = con.createStatement();
			String  query = "insert into students_info(regno, firstname, middlename, lastname) values('8', 'boy','hoy', 'Hello');";
			
			//step 4: Execute statement/Query
			 int result =st.executeUpdate(query);
			
			 if(result==1) {
				 System.out.println("Record Created Succelly");
			 }
			 else {
				 System.out.println("Record not Created");
			 }
			 // step 5: close connection
			 con.close();
		}
	}
