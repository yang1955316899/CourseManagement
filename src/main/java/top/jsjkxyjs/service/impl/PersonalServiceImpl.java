package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.PersonalDao;
import top.jsjkxyjs.dao.impl.PersonalDaoImpl;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.PersonalService;

public class PersonalServiceImpl implements PersonalService {

    /**
     * 修改密码
     *
     * @param userId      用户id
     * @param newPassword 新密码
     * @return 结果信息
     */
    @Override
    public int doChangePassword(int userId, String newPassword) {
        PersonalDao dao = new PersonalDaoImpl();
        return dao.changePassword(userId, newPassword);
    }

    /**
     * 修改个人信息
     *
     * @param user 信息
     * @return 结果
     */
    @Override
    public int doChangeMyInfo(User user) {
        PersonalDao dao = new PersonalDaoImpl();
        return dao.changeMyInfo(user);
    }

    /**
     * 判断旧密码是否输入正确
     *
     * @param userId   用户Id
     * @param password 旧密码
     * @return 结果信息
     */
    @Override
    public int doIfCorrect(int userId, String password) {
        PersonalDao dao = new PersonalDaoImpl();
        return dao.ifCorrect(userId, password);
    }
}
