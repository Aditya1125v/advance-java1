package com.rays.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectQuerys {
public static void main(String[] args) throws Exception {
	// loading driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	// connection with database
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	//statement creartion
	Statement stmt = conn.createStatement();
	//Execute query
	 ResultSet A = stmt.executeQuery("select * from  studen_detial where id=1");
	 
	 //print ke liye
	 while(A.next()) {
		 System.out.print(A.getInt(1)+ "\t" +A.getInt(2)+ "\t"+A.getString(3)+"\ts"+A.getString(4)+"\n");
		 
		 
	 }
	
	
}
}
