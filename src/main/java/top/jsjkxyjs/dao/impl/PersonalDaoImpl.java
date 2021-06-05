package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.PersonalDao;
import top.jsjkxyjs.entity.User;

public class PersonalDaoImpl extends BaseDao implements PersonalDao {
    /**
     * 修改密码
     *
     * @param userId      用户id
     * @param newPassword 新密码
     * @return 结果信息
     */
    @Override
    public int changePassword(int userId, String newPassword) {
        int i = 0;
        conn = getConnection();
        String sql = "update t_user set password = ? where userId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setInt(2, userId);
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return i;
    }

    /**
     * 修改个人信息
     *
     * @param user 信息
     * @return 结果
     */
    @Override
    public int changeMyInfo(User user) {
        int i = 0;
        conn = getConnection();
        String sql = "update t_user set userName=?,sex=?,age=? where userId=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setInt(2, user.getSex());
            ps.setInt(3, user.getAge());
            ps.setInt(4, user.getUserId());
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return i;
    }

    /**
     * 判断旧密码是否输入正确
     *
     * @param userId   用户Id
     * @param password 旧密码
     * @return 结果信息
     */
    @Override
    public int ifCorrect(int userId, String password) {
        int i = 0;
        conn = getConnection();
        String sql = "select id from t_user where userId = ? and password = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return i;
    }
}
