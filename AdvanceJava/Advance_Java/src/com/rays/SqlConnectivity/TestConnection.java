package com.rays.SqlConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TestConnection {
public static void main(String[] args) throws Exception {
	// step 1 load Driver
	Class.forName("com.mysql.cj.jdbc.Driver");
    // step 2 getConnection
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
	//step 3 creating object or call Interface
	Statement stmt = conn.createStatement();
	System.out.println(" the connection is successfully");
	
}

}
