package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.service.TeacherServer;

import java.util.List;

public class TeacherServerImpl implements TeacherServer {
	/**
	 * 测试用例
	 * System.out.println(new TeacherServerImpl().checkRoomUse(new RoomDaoImpl().getRoomUseByTime(22, 2021, 1, 1), new int[]{1, 2, 3}));
	 */

	@Override
	public boolean checkRoomUse(List<String> list, int[] ClassCode) {
		int[] classCodeTemp = new int[10];
		for (String tem : list) {
			char[] temArr = tem.toCharArray();
			for (int index = 0; index < temArr.length; index++) {
				classCodeTemp[temArr[index] - '0']++;
			}
		}
		for (int n : ClassCode)
			for (int index = 0; index < classCodeTemp.length; index++)
				if (n == index && classCodeTemp[index] > 0) {
					return false;
				}
		return true;
	}
}
