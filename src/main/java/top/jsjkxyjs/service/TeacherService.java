package top.jsjkxyjs.service;

import top.jsjkxyjs.entity.Teacher;

import java.util.List;

public interface TeacherService {
	boolean checkRoomUse(List<String> list, int[] ClassCode);
	List<Teacher> getStudentsByCourseId(int CourseId);
	List<String> getTimeByTeacherId(String TeacherId, String Year, String Semester, String Week);
	int delStudent(int StudentId);
	List<String> getCourseByTeacherId(int TeacherId);
	void updateStudent1(int Grade,int StudentId);
}
