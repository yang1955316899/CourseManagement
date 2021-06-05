package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.impl.CourseDaoImpl;
import top.jsjkxyjs.dao.impl.StudentDaoImpl;
import top.jsjkxyjs.entity.Course;
import top.jsjkxyjs.service.CourseService;
import top.jsjkxyjs.util.Helper;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {
	@Override
	public boolean setCourse(Course course) {
		return new CourseDaoImpl().setCourse(course);
	}

	@Override
	public List<Course> getChooseCourses(int UserId) {
		return new CourseServiceImpl().Check(UserId, new CourseDaoImpl().getChooseCourses());
	}

	@Override
	public List<Course> Check(int Id, List<Course> courses) {
		List<Course> newCourses = new ArrayList<>();
		List<String> ClassCode = new StudentDaoImpl().getUserCourseByUserId(Id);
		for (Course course : courses) {
			if (new Helper().timeAdd(ClassCode, new Helper().parse(course.getClassCode())))
				newCourses.add(course);
		}
		return newCourses;
	}
}
