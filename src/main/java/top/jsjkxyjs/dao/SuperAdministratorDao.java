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
     * @return user集合
     */
    List<User> superSearch(int userId, String userName);


    /**
     * 管理员添加用户
     *
     * @param user user
     * @return 结果信息
     */
    int superAddUser(User user);


    /**
     * 根据班级name获取班级id
     *
     * @param className 班级名字
     * @return 班级id
     */
    int getClassIdByClassName(String className);
}
