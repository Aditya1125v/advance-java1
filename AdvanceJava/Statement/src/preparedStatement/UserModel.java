package preparedStatement;

public class UserModel {
public static void main(String[] args) {
	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceJava", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLoginId());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(7, bean.getGender());

		int i = pstmt.executeUpdate();

		System.out.println("data inserted successfully.. " + i);

	}

	/*public void update() {
	}

	public void delete() {
	}
*/
}
}

