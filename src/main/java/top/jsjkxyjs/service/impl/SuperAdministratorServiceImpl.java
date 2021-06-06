package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.SuperAdministratorDao;
import top.jsjkxyjs.dao.impl.SuperAdministratorDaoImpl;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.SuperAdministratorService;

import java.util.List;

/**
 * 获取所有用户信息
 *
 * @author 李镇宇
 */
public class SuperAdministratorServiceImpl implements SuperAdministratorService {
    @Override
    public List<User> doGetAllUser() {
        SuperAdministratorDao dao = new SuperAdministratorDaoImpl();
        return dao.getAllUser();
    }

    /**
     * 搜索用户
     * @param userId   用户Id
     * @param userName 用户name
     * @return list集合
     */
    @Override
    public List<User> doSuperSearch(int userId, String userName) {
        SuperAdministratorDao dao = new SuperAdministratorDaoImpl();
        return dao.superSearch(userId, userName);
    }

    /**
     * 超级管理员添加用户
     *
     * @param user 用户
     * @return 结果信息
     */
    @Override
    public int doSuperAdd(User user) {
        SuperAdministratorDao dao = new SuperAdministratorDaoImpl();
        return dao.superAddUser(user);
    }

    /**
     * 根据classname获取classId
     * @param className 班级名称
     * @return 班级id
     */
    @Override
    public int doGetClassIdByClassName(String className) {
        SuperAdministratorDao dao = new SuperAdministratorDaoImpl();
        return dao.getClassIdByClassName(className);
    }
}
