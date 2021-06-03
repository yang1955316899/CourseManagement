package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.TeacherDao;

import java.util.List;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {

	@Override
	public List<String> getTimeByTeacherId(String TeacherId, String Year, String Semester, String Week) {
		String sql = "select ClassCode from t_course where Teacher = ? and Week = ? and YearSemester = ?";
		return getStrings(sql, new String[]{"" + TeacherId, "" + Week, "" + Year + Semester}, "ClassCode");
	}
}
