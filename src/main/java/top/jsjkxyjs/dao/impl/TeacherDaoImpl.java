package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.TeacherDao;
import top.jsjkxyjs.entity.Teacher;

import java.util.*;


import java.util.List;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {

	@Override
	public List<String> getTimeByTeacherId(String TeacherId, String Year, String Semester, String Week) {
		String sql = "select ClassCode from t_course where Teacher = ? and Week = ? and YearSemester = ?";
		return getStrings(sql, new String[]{"" + TeacherId, "" + Week, "" + Year + Semester}, "ClassCode");
	}

	/**
	 * 根据课程id 查看相应班级的学生成员成绩
	 **/
	public List<Teacher> geStudentsBYCoureId(int CourseId) {
		List<Teacher> list = new ArrayList<>();
		conn = getConnection();
		String sql = "select * from t_sc,t_user where StudentId = UserId and CourseId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, CourseId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setStudentId(rs.getInt("StudentId"));
				teacher.setStudentName(rs.getString("UserName"));
				teacher.setClassId(rs.getInt("ClassId"));
				teacher.setCourseId(rs.getInt("CourseId"));
				teacher.setGrade(rs.getInt("Grade"));
				list.add(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public List<String> getCourseByTeacherId(int TeacherId) {
		String sql = "select id,CourseName from t_course where Teacher = ?";
		return getStrings(sql,TeacherId,new String[]{"id","CourseName"});
	}

	/**
	 * 调用此方法，删除相应学生的信息
	 *
	 * @param StudentId 学生id
	 * @return 删除成功信息
	 */
	public int delStudent(int StudentId) {
		int i = 0;
		conn = getConnection();
		String sql = "update t_sc set state = 0 where StudentId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, StudentId);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return i;
	}

	@Override
	public void updateStudent2(int Grade,int StudentId) {
		conn = getConnection();
		String sql = "update t_sc set Grade = ? where StudentId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Grade);
			ps.setInt(2,StudentId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
	}

}
