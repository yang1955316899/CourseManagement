package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.ActionDao;
import top.jsjkxyjs.entity.Action;
import top.jsjkxyjs.util.BaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ActionDaoImpl implements ActionDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    BaseUtil util = new BaseUtil();

    @Override
    public List<Action> getActions(String roleActionId) {
        List<Action> actionsList = new ArrayList<>();
        conn = util.getConnection();

        String sql = "select * from t_action where id in (" + roleActionId + ")";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Action action = new Action();
                action.setId(rs.getInt("id"));
                action.setTitle(rs.getString("Title"));
                action.setUrl(rs.getString("URL"));
                action.setpId(rs.getInt("PID"));
                actionsList.add(action);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }

        return actionsList;
    }

    @Override
    public List<Action> getAllActions() {
        List<Action> allActionsList = new ArrayList<>();
        String sql = "select * from t_action where pId <> 0";
        conn = util.getConnection();

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Action action = new Action();
                action.setId(rs.getInt("id"));
                action.setpId(rs.getInt("PID"));
                action.setTitle(rs.getString("Title"));
                action.setUrl(rs.getString("URL"));
                allActionsList.add(action);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(conn, ps, rs);
        }
        return allActionsList;
    }
}
