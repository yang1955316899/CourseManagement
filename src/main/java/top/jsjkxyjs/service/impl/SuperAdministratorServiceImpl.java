package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.SuperAdministratorDao;
import top.jsjkxyjs.dao.impl.SuperAdministratorDaoImpl;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.SuperAdministratorService;

import java.util.List;

public class SuperAdministratorServiceImpl implements SuperAdministratorService {
    /**
     * 获取所有用户信息
     *
     * @return 信息集合
     */
    @Override
    public List<User> doGetAllUser() {
        SuperAdministratorDao dao = new SuperAdministratorDaoImpl();
        return dao.getAllUser();
    }

    /**
     * 搜索用户
     *
     * @param userId   用户Id
     * @param userName 用户name
     * @return list集合
     */
    @Override
    public List<User> doSuperSearch(int userId, String userName) {
        SuperAdministratorDao dao = new SuperAdministratorDaoImpl();
        List<User> list = dao.superSearch(userId, userName);
        return list;
    }
}
