package top.jsjkxyjs.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * 此方法构成重载,可以自行添加,查啥都行,JavaBean不行
	 *
	 * @param sql        sql语句
	 * @param args       参数
	 * @param returnType 想要从数据库中查找哪一行,如果想查多行,可以用一个for循环
	 * @return List
	 * @author 杨建文 2021-05-27 20:37:02
	 * create by IDEA
	 */
	public List<String> getStrings(String sql, String[] args, String returnType) {
		List<String> list = new ArrayList<>();
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if (args != null) {
				for (int index = 0; index < args.length; index++) {
					ps.setString(index + 1, args[index]);
				}
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(returnType));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	public List<String> getStrings(String sql, int args, String returnType) {
		List<String> list = new ArrayList<>();
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "" + args);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(returnType));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
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
