package ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Db {
	public static void main(String[] args) throws Exception {
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		
		Statement state = con.createStatement();
		
		ResultSet result = state.executeQuery("select * from project;");
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2));
		}
	}
}
