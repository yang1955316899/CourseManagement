package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.ActionDao;
import top.jsjkxyjs.entity.Action;

import java.util.ArrayList;
import java.util.List;

public class ActionDaoImpl extends BaseDao implements ActionDao {
	/**
	 * 根据t_role表中的actionId获取 相应的 action集和
	 */
	@Override
	public List<Action> getActions(String roleActionId) {
		List<Action> actionsList = new ArrayList<>();
		conn = getConnection();

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
			closeAll(rs, ps, conn);
		}

		return actionsList;
	}


	/**
	 * 获取所有的子action
	 */
	@Override
	public List<Action> getAllActions() {
		List<Action> allActionsList = new ArrayList<>();
		String sql = "select * from t_action where pId <> 0";
		conn = getConnection();

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
			closeAll(rs, ps, conn);
		}
		return allActionsList;
	}


	/**
	 * 通过roleId 获取相应的 actionId
	 */
	@Override
	public String getActionId(int roleId) {
		String actionId = "";
		conn = getConnection();
		String sql = "select * from t_role where id = ?";

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
			closeAll(rs, ps, conn);
		}
		return actionId;
	}
}
