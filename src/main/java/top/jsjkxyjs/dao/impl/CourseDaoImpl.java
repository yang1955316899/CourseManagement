package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.CourseDao;
import top.jsjkxyjs.entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl extends BaseDao implements CourseDao {
	@Override
	public List<Course> getCourseById(int id) {
		conn = getConnection();
		String sql = "select * from t_course where id = ?";
		List<Course> courses = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "" + id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("id"));
				course.setCourseName(rs.getString("CourseName"));
				course.setTeacher(rs.getInt("Teacher"));
				course.setLocation(rs.getInt("Location"));
				course.setMaxSize(rs.getInt("MaxSize"));
				course.setYearSemester(rs.getInt("YearSemester"));
				course.setDay(rs.getInt("Day"));
				course.setClassCode(rs.getInt("ClassCode"));
				course.setCreadit(rs.getFloat("Creadit"));
				course.setAssistant(rs.getInt("Assistant"));
				courses.add(course);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return courses;
	}

	@Override
	public List<String> getCourseIdByTeacherId(int teacherId) {
		String sql = "select id from t_course where Teacher = ?";
		return getStrings(sql, teacherId, "id");
	}

	@Override
	public String getCourseNameByTeacherId(int teacherId) {
		String sql = "select CourseName from t_course where Teacher = ?";
		return getString(sql, "" + teacherId, "CourseName");
	}

	@Override
	public List<String> getStudentIdsByCourse(int courseId) {
		String sql = "select StudentId from t_sc where CourseId = ?";
		return getStrings(sql, courseId, "StudentId");
	}

	@Override
	public int getGradeByStudentId(int studentId, int courseId) {
		String sql = "select Grade from t_sc where StudentId = ? and CourseId = ?";

		if (getStrings(sql, new String[]{"" + studentId, "" + courseId}, "Grade").size() > 0)
			return Integer.parseInt(getStrings(sql, new String[]{"" + studentId, "" + courseId}, "Grade").get(0));
		else
			return -1;
	}

	@Override
	public List<String> getStudentIdsByClassId(int classId) {
		String sql = "select id from t_user where ClassId = ?";
		return getStrings(sql, classId, "id");
	}

	@Override
	public List<String> getClassIdsByCounselorId(int CounselorId) {
		String sql = "select id from t_class where Counselor = ?";
		return getStrings(sql, CounselorId, "id");
	}
}
