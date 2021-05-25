package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.impl.StudentDaoImpl;
import top.jsjkxyjs.service.StudentServer;
import top.jsjkxyjs.util.Helper;

import java.util.List;

public class StudentServerImpl implements StudentServer {
	@Override
	public boolean checkTimeUse(int UserId, int year, int semester, int day, int[] classCode) {
		List<String> userTime = new StudentDaoImpl().getTimeByUserId(UserId, year, semester, day);
		return new Helper().timeAdd(userTime, classCode);
	}
}
