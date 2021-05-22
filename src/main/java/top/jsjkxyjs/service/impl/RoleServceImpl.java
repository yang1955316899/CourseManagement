package top.jsjkxyjs.service.impl;


import top.jsjkxyjs.dao.RoleDao;
import top.jsjkxyjs.dao.impl.RoleDaoImpl;
import top.jsjkxyjs.service.RoleService;

public class RoleServceImpl implements RoleService {
    @Override
    public String doGetActionIdByRoleId(int roleId) {
        RoleDao roleDao = new RoleDaoImpl();
        String actionId = roleDao.getActionIdByRoleId(roleId);
        return actionId;
    }
}
