package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.CounselorDao;
import top.jsjkxyjs.entity.User;

import java.util.ArrayList;
import java.util.List;

public class CounselorDaoImpl extends BaseDao implements CounselorDao {

	/**
	 * 根据班级id 查看相应班级的学生成员信息
	 **/
	@Override
	public List<User> viewMember(int classId) {
		conn = getConnection();
		List<User> list = new ArrayList<>();
		String sql = "select * from t_user where classId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, classId);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("UserId"));
				user.setSex(rs.getInt("Sex"));
				user.setUserName(rs.getString("UserName"));
				user.setAge(rs.getInt("Age"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}


}
