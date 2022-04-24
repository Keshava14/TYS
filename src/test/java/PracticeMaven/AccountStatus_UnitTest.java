package PracticeMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class AccountStatus_UnitTest {

	public void testAccountType() throws SQLException {
		Connection con = null;
		
		try{
		// step 1: Register/load Mysql database 
		Driver db = new Driver();
		DriverManager.registerDriver(db);
		
		//step 2: get connect to database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
					
		// Create SQL statement
		Statement st = con.createStatement();
		String  query = "select * from account";
		
		ResultSet result = st.executeQuery(query);
					
		while(result.next()) {
			int accNum = result.getInt("accno");
			if(accNum == 123 && result.getString("accontType").equalsIgnoreCase("gold")) {
				System.err.println("account type gold & verified==pass");
				break;
			}
			}
		}
		catch(Exception e) {
			System.out.println("account type gold & verified==Failed");
		}
		finally {
			// step 5: close connection
			 con.close();
		}	
		
	}
}

