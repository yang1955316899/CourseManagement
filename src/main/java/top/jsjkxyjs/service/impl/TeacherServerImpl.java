package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.impl.TeacherDao;
import top.jsjkxyjs.service.TeacherServer;

public class TeacherServerImpl implements TeacherServer {
	TeacherDao teacherDao = new TeacherDao();

	@Override
	public boolean checkMaxSize(int id, int StudentCou) {
		String sql = "select MaxSize from t_location WHERE id = ?";
		return teacherDao.RoomSize(sql, id) >= StudentCou;
	}

	@Override
	public boolean checkRoomUse(int id, String time) {
		String sql = "select * from t_course where Time = ? && id = ?";
		return teacherDao.RoomUse(sql, id, time);
	}
}
