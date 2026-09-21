package ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class CRUD_Db {
	public static void main(String[] args) throws Exception {
		Driver d = new Driver();
		
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		
		Statement st = con.createStatement();
		
		//1. execute ---------------> boolean(to create n do manipulation in db table)
		//1.1 creating table
		/*st.execute("use ninza_hrm;");
		st.execute("create table asdfghtt3 (name VARCHAR(20));");
		//1.2 inserting record
		st.execute("insert into asdfghtt3 values('asd');");
		//1.3 getting it and checking 
		boolean status = st.execute("select * from asdfghtt3;");
		
		if(status==true)
			System.out.println("table created");
		else 
			System.out.println("table not created");*/
		
		//2. executeQuert
		//2.1 reading data from db
		ResultSet set = st.executeQuery("select * from project;");
		while(set.next()) {
			System.out.println("PID:"+set.getString(1)+" CreatedBy:"+set.getString(2)+" created_on:"+set.getString(3)+
					" project_name:"+set.getString(4)+" status:"+set.getString(5)+" teamsize:"+set.getString(6));
		}
		
		
		//3. executeUpdate
		int i =st.executeUpdate("insert into project values('NH_PROJ_790','Abc','03/09/2026','HGJHGHJ','OnGoing','5');");
		System.out.println("I:"+i);
		
		con.close();
		
	}
}
