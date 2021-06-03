package top.jsjkxyjs.dao;

import top.jsjkxyjs.entity.User;

import java.util.List;

public interface SuperAdministratorDao {
    /**
     * 获取所有用户信息
     *
     * @return 用户信息列表
     */
    List<User> getAllUser();

    /**
     * 超级管理员搜索
     *
     * @param userId   用户id
     * @param userName 用户name
     * @return
     */
    List<User> superSearch(int userId, String userName);
}
