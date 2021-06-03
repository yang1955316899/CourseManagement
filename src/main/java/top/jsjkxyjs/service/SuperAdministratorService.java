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
}
