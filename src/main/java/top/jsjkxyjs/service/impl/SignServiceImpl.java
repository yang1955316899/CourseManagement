package top.jsjkxyjs.service.impl;


import top.jsjkxyjs.dao.ActionDao;
import top.jsjkxyjs.dao.SignDao;
import top.jsjkxyjs.dao.UserDao;
import top.jsjkxyjs.dao.impl.ActionDaoImpl;
import top.jsjkxyjs.dao.impl.SignDaoImpl;
import top.jsjkxyjs.dao.impl.UserDaoImpl;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.SignService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignServiceImpl implements SignService {
	@Override
	public int doSignIn(User user) {
		SignDao signDao = new SignDaoImpl();
		int roleId = signDao.getRoleId(user);
		return roleId;
	}

	@Override
	public void doSignOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SignDao signDao = new SignDaoImpl();
		signDao.signOut(req, resp);

	}

	@Override
	public String doGetActionId(int roleId) {
		ActionDao actionDao = new ActionDaoImpl();
		String actionId = actionDao.getActionId(roleId);
		return actionId;
	}


	@Override
	public User doGetInfo(int userId) {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserByUserId(userId);
		return user;
	}
}
