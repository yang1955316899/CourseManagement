package top.jsjkxyjs.dao;

import top.jsjkxyjs.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
	String getCourseTimeByCourseId(int CourseId);

	boolean setCourse(Course course);

	List<Course> getChooseCourses() throws SQLException;

	String getLocationPIDString(int LocationId);

	String getTeacherNameByTeacherId(int TeacherId);

	String getLocationTitle(String LocationId);

	boolean setChooseCourse(int UserId, int CourseId);

	List<String> getClassCodeByTime(int UserId, int YearSemester, int Week);
}
