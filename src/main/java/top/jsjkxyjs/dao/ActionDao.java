package top.jsjkxyjs.dao;


import top.jsjkxyjs.entity.Action;

import java.util.List;

public interface ActionDao {
	/**
	 * 根据role表里面的 actionId 在action表中获取相应的action信息
	 */
	List<Action> getActions(String roleActionId);

	/**
	 * 获取action表中所有的子菜单
	 */
	List<Action> getAllActions();
}
