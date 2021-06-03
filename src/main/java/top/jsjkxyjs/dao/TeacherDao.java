package top.jsjkxyjs.dao;

import java.util.List;

public interface TeacherDao {
	List<String> getTimeByTeacherId(String TeacherId, String Year, String Semester, String Week);
}
