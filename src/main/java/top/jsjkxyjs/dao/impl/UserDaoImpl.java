package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.UserDao;
import top.jsjkxyjs.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {
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
