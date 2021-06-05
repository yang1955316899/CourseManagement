package top.jsjkxyjs.dao;

import top.jsjkxyjs.entity.User;

/**
 * @author SeRein
 */
public interface PersonalDao {
    /**
     * 修改密码
     *
     * @param userId      用户id
     * @param newPassword 新密码
     * @return 结果信息
     */
    int changePassword(int userId, String newPassword);

    /**
     * 修改个人信息
     *
     * @param user 信息
     * @return 结果
     */
    int changeMyInfo(User user);


    /**
     * 判断旧密码是否输入正确
     *
     * @param userId   用户Id
     * @param password 旧密码
     * @return 结果信息
     */
    int ifCorrect(int userId, String password);
}
