package top.jsjkxyjs.service;

import top.jsjkxyjs.entity.Course;

import java.util.List;

public interface CourseService {
	boolean setCourse(Course course);

	List<Course> getChooseCourses(int UserId);

	List<Course> Check(int Id, List<Course> courses);
}
