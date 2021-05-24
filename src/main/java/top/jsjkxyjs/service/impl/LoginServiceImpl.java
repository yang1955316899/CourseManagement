package top.jsjkxyjs.service.impl;


import top.jsjkxyjs.dao.LoginDao;
import top.jsjkxyjs.dao.impl.LoginDaoImpl;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.LoginService;

public class LoginServiceImpl implements LoginService {
	@Override
	public int doLogin(User user) {
		LoginDao loginDao = new LoginDaoImpl();
		int roleId = loginDao.getRoleId(user);
		return roleId;
	}
}
