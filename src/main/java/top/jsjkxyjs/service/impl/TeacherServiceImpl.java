package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.impl.TeacherDaoImpl;
import top.jsjkxyjs.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
	/**
	 * 测试用例
	 * System.out.println(new TeacherServerImpl().checkRoomUse(new RoomDaoImpl().getRoomUseByTime(22, 2021, 1, 1), new int[]{1, 2, 3}));
	 */

	@Override
	public List<String> getTimeByTeacherId(String TeacherId, String Year, String Semester, String Week) {
		return new TeacherDaoImpl().getTimeByTeacherId(TeacherId, Year, Semester, Week);
	}
}