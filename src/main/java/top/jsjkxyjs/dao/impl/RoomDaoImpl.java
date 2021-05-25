package top.jsjkxyjs.dao.impl;


import top.jsjkxyjs.dao.RoomDao;

import java.util.List;

public class RoomDaoImpl extends BaseDao implements RoomDao {

	@Override
	public List<String> getRoomByLocationId(int id) {
		String sql = "select Title from t_location where PID = ?";
		return getStrings(sql, id, "Title");
	}

	@Override
	public List<String> getAllLocation() {
		String sql = "select Title from t_location where PID = 0";
		return getStrings(sql, null, "Title");
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
