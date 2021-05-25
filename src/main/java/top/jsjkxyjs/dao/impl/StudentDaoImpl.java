package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.StudentDao;

import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {
//	@Override
//	public List<String> getUserCourseByUserId(int UserId) {
//		String sql = "select * from t_sc where StudentId = ?";
//		return getStrings(sql, UserId, "CourseId");
//	}

	@Override
	public List<String> getTimeByUserId(int UserId, int year, int semester, int day) {
		String[] args = new String[]{"" + UserId, "" + year + semester, "" + day};
		String sql = "select ClassCode from t_course,t_sc WHERE t_course.id = t_sc.CourseId and t_sc.StudentId = ? and YearSemester = ? AND Day = ?";
		return getStrings(sql, args, "ClassCode");
	}


}
