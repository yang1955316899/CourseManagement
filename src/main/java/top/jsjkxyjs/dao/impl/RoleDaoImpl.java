package top.jsjkxyjs.dao.impl;


import top.jsjkxyjs.dao.RoleDao;
import top.jsjkxyjs.util.BaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleDaoImpl implements RoleDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    BaseUtil util = new BaseUtil();

    @Override
    public String getActionIdByRoleId(int roleId) {
        conn = util.getConnection();
        String sql = "select * from t_role where id = ?";
        String actionId = "";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();
            if (rs.next()) {
                actionId = rs.getString("ActionID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }


        return actionId;
    }
}
