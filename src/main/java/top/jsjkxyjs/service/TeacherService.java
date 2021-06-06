package top.jsjkxyjs.service;

import top.jsjkxyjs.entity.Teacher;

import java.util.List;

public interface TeacherService {
	List<Teacher> getStudentsByCourseId(int CourseId);

	List<String> getTimeByTeacherId(String TeacherId, String Year, String Semester, String Week);

	List<String> getCourseByTeacherId(int TeacherId);

	void updateStudent1(int Grade, int StudentId);
}
