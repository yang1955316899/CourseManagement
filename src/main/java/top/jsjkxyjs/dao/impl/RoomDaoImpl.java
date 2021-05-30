package top.jsjkxyjs.dao.impl;


import top.jsjkxyjs.dao.RoomDao;
import top.jsjkxyjs.entity.Location;

import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl extends BaseDao implements RoomDao {

	@Override
	public List<Location> getRoomByLocationId(int locationId) {
		String sql = "select * from t_location where PID = ?";
		conn = getConnection();
		List<Location> location = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "" + locationId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Location tem = new Location();
				tem.setId(rs.getInt("id"));
				tem.setTitle(rs.getString("Title"));
				tem.setPID(rs.getInt("PID"));
				tem.setMaxSize(rs.getInt("MaxSize"));
				location.add(tem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return location;
	}

	@Override
	public List<Location> getAllLocation() {
		conn = getConnection();
		List<Location> location = new ArrayList<>();
		String sql = "select * from t_location where PID = 0";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Location tem = new Location();
				tem.setId(rs.getInt("id"));
				tem.setTitle(rs.getString("Title"));
				tem.setPID(rs.getInt("PID"));
				tem.setMaxSize(rs.getInt("MaxSize"));
				location.add(tem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return location;
	}

	@Override
	public int getMaxSizeById(int id) {
		String sql = "select MaxSize from t_location where id = ?";
		return Integer.parseInt(getStrings(sql, id, "MaxSize").get(0));
	}

	@Override
	public List<String> getRoomUseByTime(int locationId, int year, int semester, int day) {
		String sql = "select ClassCode from t_course where Location = ? && YearSemester = ? && Day = ?";
		String[] args = new String[]{"" + locationId, "" + year + semester, "" + day};
		return getStrings(sql, args, "ClassCode");
	}

	@Override
	public String getRoomByCourseId(String CourseId) {
		String sql = "select Location from t_course where id = ?";
		return getString(sql, CourseId, "Location");
	}

}
