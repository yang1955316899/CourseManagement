package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.UserDao;
import top.jsjkxyjs.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	/**
	 * 调用此方法，在数据库考中添加一个新用户
	 */
	@Override
	public int addUser(User user) {
		conn = getConnection();
		String sql = "insert into t_user (UserName,Password,RoleId,UserId,Sex,Age,ClassId) values (?,?,?,?,?,?,?)";
		String[] arr = {user.getUserName(), user.getPassword(), String.valueOf(user.getRoleId()),
				String.valueOf(user.getUserId()), String.valueOf(user.getSex()),
				String.valueOf(user.getAge()), String.valueOf(user.getClassId())};
		int i = excuteSQL(sql, arr);
		return i;
	}


	/**
	 * 调用此方法，通过uerId返回完整的user
	 */
	@Override
	public User getUserByUserId(int userId) {
		User user = new User();
		String sql = "select * from t_user where UserId = ?";
		conn = getConnection();

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUserId(rs.getInt("UserId"));
				user.setUserName(rs.getString("UserName"));
				user.setPassword(rs.getString("PassWord"));
				user.setSex(rs.getInt("Sex"));
				user.setRoleId(rs.getInt("RoleId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return user;
	}
}
