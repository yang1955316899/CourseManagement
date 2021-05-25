package top.jsjkxyjs.dao.impl;

import java.util.List;

public class TeacherDaoImpl extends BaseDao implements top.jsjkxyjs.dao.TeacherDao {
	@Override
	public List<String> getUserCourseByUserId(int UserId) {
		String sql = "select * from t_sc where StudentId = ?";
		return getStrings(sql, UserId, "CourseId");
	}

}
