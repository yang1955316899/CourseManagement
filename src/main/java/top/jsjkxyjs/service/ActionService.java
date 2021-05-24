package top.jsjkxyjs.service;


import top.jsjkxyjs.entity.Action;

import java.util.List;

public interface ActionService {
	List<Action> doGetActions(String roleActionId);

	List<Action> doGetAllActions();
}
