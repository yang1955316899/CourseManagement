package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.UserDao;
import top.jsjkxyjs.dao.impl.UserDaoImpl;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public int doAddUser(User user) {
        UserDao userDao = new UserDaoImpl();
        int i = userDao.addUser(user);
        return i;
    }
}
