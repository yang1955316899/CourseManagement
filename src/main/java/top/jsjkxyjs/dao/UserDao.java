package top.jsjkxyjs.dao;

import top.jsjkxyjs.entity.User;

public interface UserDao {
    User getUserByUserId(int userId);

    int addUser(User user);

}
