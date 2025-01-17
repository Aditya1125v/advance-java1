package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel1 {

	public void add(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook", "root", "root");
		UserBean existBean =  findbyloginid(bean.getLogin_Id());
		if (existBean != null) {

			System.out.println("LoginId already exist plead use diffrent Email");

		} else {PreparedStatement pstmt = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, generateid());
		pstmt.setString(2, bean.getFirst_name());
		pstmt.setString(3, bean.getLast_name());
		pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(5, bean.getLogin_Id());
		pstmt.setString(6, bean.getPassword());
		pstmt.setLong(7, bean.getMobile_No());
		int i = pstmt.executeUpdate();
		System.out.println("data inserted successfully.. " + i);
	}
	}
	public void update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("update users set First_Name = ? where id = ?");

		pstmt.setString(1, bean.getFirst_name());
		pstmt.setInt(2, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("data inserted successfully.. " + i);

	}
	public void delete(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from users where id =?");
		pstmt.setInt(1,bean.getId());
		
		int i = pstmt.executeUpdate();
		System.out.println("delete data successfully.. " + i);
	}
	
	public int generateid()throws Exception {
		int Gr=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook", "root", "root" );
	PreparedStatement pstmt = conn.prepareStatement("select max(id) from users");
	  ResultSet rs = pstmt.executeQuery();
	  while(rs.next()) {
		  Gr =rs.getInt(1);
		  System.out.println("max id = " + Gr);
	  }
	  return Gr + 1;}
		  
	  
	public UserBean findbyloginid(String loginid)throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook", "root", "root" );
		PreparedStatement pstmt = conn.prepareStatement("select Login_id from users where id=?");
		pstmt.setString(1, loginid);
		ResultSet rs = pstmt.executeQuery();
/*		System.out.println("data "+rs);*/
		UserBean bean =null;
		while(rs.next()){
			bean=new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirst_name(rs.getString(2));
			bean.setLast_name(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setLogin_Id(rs.getString(5));
			bean.setPassword(rs.getString(6));
			bean.setMobile_No(rs.getLong(7));
			
/*		}else {System.out.println("Login exist already");* 
*/  }
		return bean;
	}
	public List search(UserBean bean)throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebook", "root", "root" );
		StringBuffer sql = new StringBuffer("select * from users where 1=1");
		if(bean != null) {
			if(bean.getFirst_name()!=null && bean.getFirst_name().length()>0) {
				sql.append(" and First_Name like '"+ bean.getFirst_name()+"'" );
			}
			if(bean.getLast_name()!=null && bean.getLast_name().length()>0) {
				sql.append(" and Last_Name like '"+ bean.getLast_name()+"'" );
				}
		}
			   System.out.println("Query ======>"+sql.toString());
			   PreparedStatement pstmt =conn.prepareStatement(sql.toString());
			   ResultSet rs = pstmt.executeQuery();
			   List list =new ArrayList();
			   while(rs.next()) {
				   bean =new UserBean();
				   bean.setId(rs.getInt(1));
				   bean.setFirst_name(rs.getString(2));
				   bean.setLast_name(rs.getString(3));
				   bean.setDob(rs.getDate(4));
				   bean.setLogin_Id(rs.getString(5));
				   bean.setPassword(rs.getString(6));
				   bean.setMobile_No(rs.getLong(7));
				   list.add(bean);
			   }
			   return list;
}}
			
				   
		
		


	

