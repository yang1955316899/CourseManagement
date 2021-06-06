package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.CourseDao;
import top.jsjkxyjs.dao.impl.CourseDaoImpl;
import top.jsjkxyjs.entity.Course;
import top.jsjkxyjs.service.CourseService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 19553
 */
public class CourseServiceImpl implements CourseService {
    @Override
    public boolean setCourse(Course course) {
        return new CourseDaoImpl().setCourse(course);
    }

    @Override
    public String getCourseTimeByCourseId(int courseId) {
        return new CourseDaoImpl().getCourseTimeByCourseId(courseId);
    }

    @Override
    public List<Course> getChooseCourses(int userId) {
        List<Course> chooseCourse = new ArrayList<>();
        List<Course> allChooseCourse = new CourseDaoImpl().getChooseCourses();
        for (Course course : allChooseCourse) {
            if (check(userId, course.getId(), Integer.parseInt(course.getYearSemester()), course.getWeek())) {
                chooseCourse.add(course);
            }
        }
        return chooseCourse;
    }

    @Override
    public boolean check(int userId, int courseId, int yearSemester, int week) {
        List<String> courses = new CourseServiceImpl().getClassCodeByTime(userId, yearSemester, week);
        String course = new CourseServiceImpl().getCourseTimeByCourseId(courseId);
        int[] classCodeTemp = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (String classCode : courses) {
            char[] classCodeInt = classCode.toCharArray();
            for (int index = 0; index < classCodeInt.length; index++) {
                if (classCodeInt[index] == '0') {
                    classCodeTemp[index] = 0;
                }
            }
        }
        char[] classCodeInt = course.toCharArray();
        for (int index = 1; index < course.length(); index++) {

            if (classCodeTemp[index] == 0 && classCodeInt[index] == '0') {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean setChooseCourse(int userId, int courseId, int yearSemester, int week) {
        if (check(userId, courseId, yearSemester, week)) {
            return new CourseDaoImpl().setChooseCourse(userId, courseId);
        } else {
            return false;
        }
    }


    @Override
    public List<String> getClassCodeByTime(int userId, int yearSemester, int week) {
        return new CourseDaoImpl().getClassCodeByTime(userId, yearSemester, week);
    }
}
