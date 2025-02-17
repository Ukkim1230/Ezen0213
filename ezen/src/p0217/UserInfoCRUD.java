package p0217;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInfoCRUD {

	private static final String URL = "jdbc:mysql://localhost:3306/ezen";
	private static final String USER = "root";
	private static final String PASSWORD = "r1r2r3";
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static Connection con = null;
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static int insertUserInfo(String uiName, String uiId, String uiPwd) {
		try {
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO USER_INFO(UI_NAME,UI_ID,UI_PWD)";
			sql += "VALUES('" + uiName + "','" + uiId + "','" + uiPwd + "')";
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int deleteUserInfo(int uiNum) {
		try {
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM USER_INFO WHERE UI_NUM=" + uiNum;
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int updateUserInfo(String uiName, String uiId, String uiPwd) {
		try {
			Statement stmt = con.createStatement();
			String sql = "UPDATE USER_INFO SET UI_NAME WHERE UI_NAME='홍길동'";
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		int result = insertUserInfo("홍길동", "hong", "r1r2r3");
		System.out.println("입력한 갯수 :" + result);
		result = deleteUserInfo(3);
		System.out.println("삭제한 갯수 : " + result);
	}
}