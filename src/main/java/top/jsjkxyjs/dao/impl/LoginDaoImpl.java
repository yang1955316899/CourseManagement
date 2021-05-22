package top.jsjkxyjs.dao.impl;


import top.jsjkxyjs.dao.LoginDao;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.util.BaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    BaseUtil util = new BaseUtil();

    @Override
    public int getRoleId(User user) {
        conn = util.getConnection();
        String sql = "select * from t_user where UserId = ? and Password = ?";
        int roleId = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                roleId = rs.getInt("RoleId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }
        return roleId;
    }
}
