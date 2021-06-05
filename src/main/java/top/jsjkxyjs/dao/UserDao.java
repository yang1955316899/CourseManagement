package top.jsjkxyjs.dao;

import top.jsjkxyjs.entity.User;

public interface UserDao {
    /**
     * 获取全部user信息
     *
     * @param userId userId
     * @return User对象
     */
    User getUserByUserId(int userId);

    /**
     * 添加用户
     *
     * @param user uer对象
     * @return 结果信息
     */
    int addUser(User user);

    String getRoleName(int roleId);
}
