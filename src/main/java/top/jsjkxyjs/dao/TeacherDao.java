package top.jsjkxyjs.dao;

import top.jsjkxyjs.entity.Teacher;

import java.util.List;

public interface TeacherDao {
	List<String> getTimeByTeacherId(String TeacherId, String Year, String Semester, String Week);

	List<Teacher> geStudentsByCoureId(int CourseId);

	List<String> getCourseByTeacherId(int TeacherId);

	int delStudent(int StudentId);

	void updateStudent2(int Grade, int StudentId);
}
