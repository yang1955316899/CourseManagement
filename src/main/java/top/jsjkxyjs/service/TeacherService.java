package top.jsjkxyjs.service;

import java.util.List;

public interface TeacherService {
	boolean checkRoomUse(List<String> list, int[] ClassCode);

	List<String> getTimeByTeacherId(String TeacherId, String Year, String Semester, String Week);
}
