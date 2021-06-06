package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.CourseDao;
import top.jsjkxyjs.entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CourseDaoImpl extends BaseDao implements CourseDao {
	@Override
	public boolean setCourse(Course course) {
		String sql = "insert into t_course (CourseName,Teacher,Location,MaxSize,YearSemester,Week,ClassCode,Credit,Introduction,Choose)values(?,?,?,?,?,?,?,?,?,?)";
		return excuteSQL(sql, new String[]{course.getCourseName(), course.getTeacher() + "", course.getRoom() + "", course.getMaxSize() + "", course.getYearSemester(), course.getWeek() + "", course.getClassCode(), course.getCredit() + "", course.getIntroduction(), course.getChoose() + ""}) > 0;
	}

	public String getCourseTimeByCourseId(int CourseId) {
		String sql = "select ClassCode from t_course where id = ?";
		return getStrings(sql, CourseId, "ClassCode").get(0);
	}

	public String YearSemester() {
		Calendar cal = Calendar.getInstance();

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String currXueqi = year + "1";
		if (month > 8 || month < 2) {
			currXueqi = year + "2";
		}
		return currXueqi;
	}

	@Override
	public List<Course> getChooseCourses() {
		List<Course> list = new ArrayList<>();
		conn = getConnection();
		String sql = "select t_course.*,count from (select count(StudentId) count,id from (select * from (select id from t_course where Choose = 1) t_id left join t_sc on t_id.id = t_sc.CourseId) t_count group by id) t_count,t_course where t_count.id = t_course.id and count < MaxSize and YearSemester =" + YearSemester();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("id"));
				course.setCourseName(rs.getString("CourseName"));
				course.setTeacher(rs.getInt("Teacher"));
				course.setRoom(rs.getInt("Location"));
				course.setMaxSize(rs.getInt("MaxSize"));
				course.setYearSemester(rs.getString("YearSemester"));
				course.setWeek(rs.getInt("Week"));
				course.setClassCode(rs.getString("ClassCode"));
				course.setCredit(rs.getInt("Credit"));
				course.setIntroduction(rs.getString("Introduction"));
				course.setChoose(rs.getInt("Choose"));
				list.add(course);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		for (Course course : list) {
			String LocationName = getLocationTitle(getLocationPIDString(course.getRoom()));
			String RoomName = getLocationTitle("" + course.getRoom());
			course.setRoomName(LocationName + RoomName);
			course.setTeacherName(getTeacherNameByTeacherId(course.getTeacher()));
		}
		return list;
	}

	public String getLocationPIDString(int LocationId) {
		String sql = "select PID from t_location where id = ?";
		return getStrings(sql, LocationId, "PID").get(0);
	}

	public String getLocationTitle(String LocationId) {
		String sql = "select Title from t_location where id = ?";
		return getStrings(sql, new String[]{LocationId}, "Title").get(0);
	}

	public String getTeacherNameByTeacherId(int TeacherId) {
		String sql = "select UserName from t_user where UserId = ?";
		return getStrings(sql, TeacherId, "UserName").get(0);
	}

	public boolean setChooseCourse(int UserId, int CourseId) {
		String sql = "insert into t_sc (StudentId,CourseId)values(?,?)";
		return excuteSQL(sql, new String[]{UserId + "", CourseId + ""}) > 0;
	}

	@Override
	public List<String> getClassCodeByTime(int UserId, int YearSemester, int Week) {
		String sql = "select ClassCode from t_course,t_sc where t_course.id = t_sc.CourseId and YearSemester = ? and Week = ? and t_sc.StudentId = ?";
		return getStrings(sql, new String[]{"" + YearSemester, Week + "", UserId + ""}, "ClassCode");
	}
}
