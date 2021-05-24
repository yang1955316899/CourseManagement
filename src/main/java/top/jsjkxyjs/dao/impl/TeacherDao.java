package top.jsjkxyjs.dao.impl;

import java.sql.SQLException;

public class TeacherDao extends BaseDao {
	public int RoomSize(String sql, int id) {
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "" + id);
			ps.executeQuery();
			rs.next();
			return Integer.parseInt(rs.getString("MaxSize"));
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return -1;
		} finally {
			closeAll(rs, ps, conn);
		}
	}

	public boolean RoomUse(String sql, int id, String time) {
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, time);
			ps.setString(2, "" + id);
			ps.executeQuery();
			return rs.next();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return false;
	}
}
