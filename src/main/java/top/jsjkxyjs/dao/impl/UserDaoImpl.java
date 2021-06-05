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
     * 获取角色名称
     *
     * @param userId 角色id
     * @return 角色名称
     */
    @Override
    public String getRoleName(int userId) {
        String roleName = "";
        conn = getConnection();
        System.out.println(userId);
        String sql = "select t_role.title from t_user,t_role where t_user.roleId = t_role.id and t_user.userId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                roleName = rs.getString("title");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }

        return roleName;
    }


    /**
     * 获取完整user信息
     *
     * @param userId userId
     * @return user对象
     */
    @Override
    public User getUserByUserId(int userId) {
        User user = new User();
        String roleName = getRoleName(userId);
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
                user.setAge(rs.getInt("Age"));
                user.setRoleId(rs.getInt("RoleId"));
                user.setRoleName(roleName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return user;
    }
}
