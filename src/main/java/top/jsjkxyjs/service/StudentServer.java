package top.jsjkxyjs.service;

public interface StudentServer {
	boolean checkTimeUse(int UserId, int year, int semester, int day, int[] classCode);
}
