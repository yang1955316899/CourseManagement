package top.jsjkxyjs.service;

public interface TeacherServer {
	/**
	 * 检测老师插入课程时,是否上课人数>教师最大容量
	 *
	 * @param id         教室号
	 * @param StudentCou 学生容量
	 * @return 是否能插入成功
	 */
	boolean checkMaxSize(int id, int StudentCou);

	/**
	 * 检查教室是否被使用
	 *
	 * @param id
	 * @param time
	 * @return
	 */
	boolean checkRoomUse(int id, String time);
}
