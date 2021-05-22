package top.jsjkxyjs.service.impl;


import top.jsjkxyjs.dao.ActionDao;
import top.jsjkxyjs.dao.impl.ActionDaoImpl;
import top.jsjkxyjs.entity.Action;
import top.jsjkxyjs.service.ActionService;

import java.util.List;

public class ActionServiceImpl implements ActionService {
    @Override
    public List<Action> doGetActions(String roleActionId) {
        ActionDao actionDao = new ActionDaoImpl();
        List<Action> actionsList = actionDao.getActions(roleActionId);
        return actionsList;
    }

    @Override
    public List<Action> doGetAllActions() {
        ActionDao actionDao = new ActionDaoImpl();
        List<Action> allActionsList = actionDao.getAllActions();
        return allActionsList;
    }

}
