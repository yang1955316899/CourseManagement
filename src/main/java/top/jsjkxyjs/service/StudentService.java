package top.jsjkxyjs.service;

public interface StudentService {
	boolean checkTimeUse(int UserId, int year, int semester, int day, String classCode);
}
