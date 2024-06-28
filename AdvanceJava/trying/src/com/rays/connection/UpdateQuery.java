package com.rays.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class UpdateQuery {
	public static void main(String[] args) throws Exception {
		// step for Driver-Loader
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "root");
		Statement stmt = conn.createStatement();
		System.out.println("Connection is successfully");

	

		// update query
		
		/*
		 * stmt.
		 * executeUpdate("insert into Students values(id int primary key, Roll_no int, Name varchar(25), Address varchar(60), DOB Date, Mobile_no long)"
		 * );
		 */
		 
		/*int A = stmt.executeUpdate("insert into students values(1, 11, 'himanshu sharma', 'hydrabad', '2004-09-12', 8735344782),(2, 12, 'ritik', 'delhi', '2003-12-02', 9898762156),(3, 13, 'tara sitariya', 'sehore', '2006-08-15', 9834189094)");
		System.out.println("Update ");*/
		
		ResultSet B = stmt.executeQuery("Select * from Students"); 
		  while (B.next()) {
		  System.out.println(B.getInt(1)+"\t"+B.getInt(2)+"\t"+B.getString(3)+"\t"+B.getString(4)+"\n");
		  
		 
	}
}
}