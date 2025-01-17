package com.rays.statements;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

public class CreateMethodsOfStatements {
	public static void main(String[] args) throws Exception {
	    //InsertData();
		//CreateTable();
		// DeleteRows();
		//UpdateData();
		search();
		//authenticate();
	}

	/*
	 * public static void CreateTable() throws Exception { // driver loader
	 * Class.forName("com.mysql.cj.jdbc.Driver"); // call connection Connection conn
	 * = DriverManager.getConnection("jdbc:mysql://localhost:3306/Facebook", "root",
	 * "root"); Statement stmt = conn.createStatement(); int i = stmt.executeUpdate(
	 * "create table Users(id int primary key, First_Name varchar(50), Last_Name varchar(50), DOB Date, Login_Id varchar(50), Passward varchar(50), Mobile_no long"
	 * ); System.out.println("update " + i); }
	 */
	public static void CreateTable() throws Exception { 
	    // Load the MySQL JDBC driver
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    
	    // Establish a connection to the database
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Facebook", "root", "root");
	    
	    // Create a statement object to execute SQL queries
	    Statement stmt = conn.createStatement();
	    
	    // Define the SQL query to create the Users table
		/*
		 * String sql = "CREATE TABLE Users (" + "id INT PRIMARY KEY, " +
		 * "First_Name VARCHAR(50), " + "Last_Name VARCHAR(50), " + "DOB DATE, " +
		 * "Login_Id VARCHAR(50), " + "Password VARCHAR(50), " + "Mobile_no BIGINT)";
		 */
	    
	    // Execute the SQL query to create the table
	    int i = stmt.executeUpdate("CREATE TABLE Paynments(id int PRIMARY KEY, First_Name VARCHAR(50),Last_Name VARCHAR(50), Paynments varchar(20))");// call sql make table
	    
	    // Print the result of the table creation
	    System.out.println("update " + i);
	    
	    // Close the statement and connection to free up resources
	   stmt.close();
	    conn.close();
	   
	}

	
	  public static void InsertData() throws Exception {
		  //driver loader
	 
	  Class.forName("com.mysql.cj.jdbc.Driver"); 
	  //call connection 
	  Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Facebook", "root", "root"); 
	  Statement stmt =conn.createStatement();
	  int b = stmt.executeUpdate("insert into users values(5, 'vinay', 'singh', '2000-12-23', 'vinaySingh@gmail.com', 'vinay@123', 8989891424),(2, 'Devendra', 'yadav', '2005-05-21', 'YadavDevendra@gmail.com', 'ajVerma@123', 7989891234),(3, 'shivani', 'sahu', '2010-12-13', 'shivanisahu@gmail.com', 'shivani@123', 8989121214),(4, 'Faruk', 'Khan', '2004-02-29', 'KhanKK@gmail.com', 'Faruk@123', 8989564389)");
	  
       System.out.println("update "+b);
	 }
	  public static void DeleteRows() throws Exception {
		  Class.forName("com.mysql.cj.jdbc.Driver"); 
		  //call connection 
		  Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Facebook", "root", "root"); 
		  Statement stmt =conn.createStatement();
		  int b = stmt.executeUpdate("Delete from users where id=2");
		  System.out.println("Delete ."+b);
		  
	  }
	  public static void UpdateData()throws Exception{
		  Class.forName("com.mysql.cj.jdbc.Driver"); 
		  //call connection 
		  Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Facebook", "root", "root"); 
		  Statement stmt =conn.createStatement();
		 int b = stmt.executeUpdate("update users set First_Name='Rajesh' where id=5");
	       System.out.println("Update "+b); 
	  }
	  public static void search() throws Exception {
		  Class.forName("com.mysql.cj.jdbc.Driver"); 
		  //call connection 
		  Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Facebook", "root", "root"); 
		  Statement stmt =conn.createStatement();
		 ResultSet a = stmt.executeQuery("select Login_Id,Password from users where Login_Id='gouravtaneja@gmail.com' and Password='vinay@123' " );
		 if (a.next()){
			System.out.println("Login/Password found ");
			}
		 else {System.out.println("Login/Password not found ");
	     }
	  
	  }
	  public static void authenticate() throws Exception{
		  Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Facebook", "root", "root");

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt
					.executeQuery("select * from users where Login_Id = 'vinaySingh@gmail.com' and Password = 'vinay@123'");

			if (rs.next()) {

				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getDate(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getLong(7));

			} else {
				System.out.println("loginId or Password is invalid");
			}
		  
		  
	  }
	  }
	  

