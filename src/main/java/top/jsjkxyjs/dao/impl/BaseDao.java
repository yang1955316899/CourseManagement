package top.jsjkxyjs.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Connection getConnection() {
		Connection conn = null;

		String url = "jdbc:mysql://jsjkxyjs.top:3306/coursemanagement";
		String user = "admin";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}


	public int excuteSQL(String sql, String[] arr) {
		int cou = 0;
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if (arr != null && arr.length > 0) {
				for (int tem = 1; tem <= arr.length; tem++) {
					ps.setString(tem, arr[tem - 1]);
				}
			}
			cou = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return cou;
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
