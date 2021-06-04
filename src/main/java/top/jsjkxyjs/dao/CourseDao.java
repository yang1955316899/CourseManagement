package top.jsjkxyjs.dao;

import top.jsjkxyjs.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
	//通用
	List<Course> getCourseById(int id);

	// 老师使用
	List<String> getCourseIdByTeacherId(int teacherId);

	String getCourseNameByTeacherId(int teacherId);

	List<String> getStudentIdsByCourse(int courseId);

	/**
	 * 通过学号+课程号得到成绩
	 *
	 * @param studentId
	 * @param courseId
	 * @return -1表示没有成绩
	 */
	int getGradeByStudentId(int studentId, int courseId);

	// 辅导员专用
	List<String> getStudentIdsByClassId(int classId);

	List<String> getClassIdsByCounselorId(int CounselorId);

	boolean setCourse(Course course);

	List<Course> getChooseCourses() throws SQLException;

	String getLocationPIDString(int LocationId);

	String getTeacherNameByTeacherId(int TeacherId);

	String getLocationTitle(String LocationId);
}
