package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.impl.CourseDaoImpl;
import top.jsjkxyjs.entity.Course;
import top.jsjkxyjs.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
	@Override
	public boolean setCourse(Course course) {
		return new CourseDaoImpl().setCourse(course);
	}

	public String getCourseTimeByCourseId(int CourseId) {
		return new CourseDaoImpl().getCourseTimeByCourseId(CourseId);
	}

	@Override
	public List<Course> getChooseCourses(int UserId) {
		return new CourseDaoImpl().getChooseCourses();
	}

	@Override
	public boolean Check(int UserId, int CourseId, int YearSemester, int Week) {
		List<String> courses = new CourseServiceImpl().getClassCodeByTime(UserId, YearSemester, Week);
		String course = new CourseServiceImpl().getCourseTimeByCourseId(CourseId);
		int[] classCodeTemp = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		for (String classCode : courses) {
			char[] classCodeInt = classCode.toCharArray();
			for (int index = 0; index < classCodeInt.length; index++)
				if (classCodeInt[index] == '0') classCodeTemp[index] = 0;
		}
		char[] classCodeInt = course.toCharArray();
		for (int index = 1; index < course.length(); index++) {

			if (classCodeTemp[index] == 0 && classCodeInt[index] == '0')
				return false;
		}
		return true;
	}

	@Override
	public boolean setChooseCourse(int UserId, int CourseId, int YearSemester, int Week) {
		if (Check(UserId, CourseId, YearSemester, Week))
			return new CourseDaoImpl().setChooseCourse(UserId, CourseId);
		else
			return false;
	}


	@Override
	public List<String> getClassCodeByTime(int UserId, int YearSemester, int Week) {
		return new CourseDaoImpl().getClassCodeByTime(UserId, YearSemester, Week);
	}
}
