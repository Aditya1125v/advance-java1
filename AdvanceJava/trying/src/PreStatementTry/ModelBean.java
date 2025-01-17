package PreStatementTry;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class ModelBean {
	    
	    public void add(UserBean bean) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/facebook" ;
	        try (Connection conn = DriverManager.getConnection(url, "root", "root");
	             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (id, first_name, last_name, dob, login_Id, password, mobile_No) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

	            pstmt.setInt(1, bean.getId());
	            pstmt.setString(2, bean.getFirst_name());
	            pstmt.setString(3, bean.getLast_name());
	            pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime())); // Assuming dob is java.util.Date
	            pstmt.setString(5, bean.getLogin_Id());
	            pstmt.setString(6, bean.getPassword());
	            pstmt.setLong(7, bean.getMobile_No());
	            int i = pstmt.executeUpdate();
	            System.out.println("Data inserted successfully.. " + i);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



