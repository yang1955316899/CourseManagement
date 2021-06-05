package top.jsjkxyjs.service;

import java.util.List;

public interface TeacherService {
	List<String> getTimeByTeacherId(String TeacherId, String Year, String Semester, String Week);
}
