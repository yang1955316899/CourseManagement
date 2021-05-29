package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.service.TeacherService;
import top.jsjkxyjs.util.Helper;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
	/**
	 * 测试用例
	 * System.out.println(new TeacherServerImpl().checkRoomUse(new RoomDaoImpl().getRoomUseByTime(22, 2021, 1, 1), new int[]{1, 2, 3}));
	 */

	@Override
	public boolean checkRoomUse(List<String> list, int[] classCode) {
		return new Helper().timeAdd(list, classCode);
	}
}