package top.jsjkxyjs.service;

import top.jsjkxyjs.entity.User;

import java.util.List;

public interface SuperAdministratorService {
    /**
     * 获取所有用户信息
     *
     * @return 信息集合
     */
    List<User> doGetAllUser();

    /**
     * 搜索用户
     *
     * @param userId   用户Id
     * @param userName 用户name
     * @return list集合
     */
    List<User> doSuperSearch(int userId, String userName);

    /**
     * 超级管理员添加用户
     *
     * @param user 用户
     * @return 结果信息
     */
    int doSuperAdd(User user);

    /**
     * 根据classname获取classId
     *
     * @param className 班级名称
     * @return 班级id
     */
    int doGetClassIdByClassName(String className);
}
