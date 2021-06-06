package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.CourseDao;
import top.jsjkxyjs.dao.impl.CourseDaoImpl;
import top.jsjkxyjs.entity.Course;
import top.jsjkxyjs.service.CourseService;

public class CourseServiceImpl implements CourseService {
	@Override
	public boolean setCourse(Course course) {
		return new CourseDaoImpl().setCourse(course);
	}
}
