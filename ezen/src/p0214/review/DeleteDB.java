package p0214.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDB {

public static void main(String[] args) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	String url = "jdbc:mysql://localhost:3306/ezen";
	String username = "root";
	String password = "r1r2r3"; 
	
	try {
		Connection con = DriverManager.getConnection(url,username,password);
		Statement stmt = con.createStatement();
		String sql = "DELETE FROM FOOD_INFO";
		sql += " WHERE FI_NAME='김밥'";
		int result = stmt.executeUpdate(sql);
		if(result>=1) {
			System.out.println("삭제 성공!");
		}else {
			System.out.println("삭제 X");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
