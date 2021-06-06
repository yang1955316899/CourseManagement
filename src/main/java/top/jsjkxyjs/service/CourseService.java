package top.jsjkxyjs.service;

import top.jsjkxyjs.entity.Course;

import java.util.List;

public interface CourseService {
	boolean setCourse(Course course);

	List<Course> getChooseCourses(int UserId);

	String getCourseTimeByCourseId(int CourseId);

	boolean Check(int UserId, int Id, int YearSemester, int Week);

	boolean setChooseCourse(int UserId, int CourseId, int YearSemester, int Week);

	List<String> getClassCodeByTime(int UserId, int YearSemester, int Week);
}
