package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.impl.StudentDaoImpl;
import top.jsjkxyjs.service.StudentService;
import top.jsjkxyjs.util.Helper;

import java.util.List;

public class StudentServiceImpl implements StudentService {
	@Override
	public boolean checkTimeUse(int UserId, int year, int semester, int day, String classCode) {
		List<String> userTime = new StudentDaoImpl().getTimeByUserId(UserId, year, semester, day);
		return new Helper().timeAdd(userTime, new Helper().parse(classCode));
	}
}