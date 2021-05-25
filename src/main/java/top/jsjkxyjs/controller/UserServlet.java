package top.jsjkxyjs.controller;

import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.UserService;
import top.jsjkxyjs.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {
	/**
	 * 调用此方法，往 t_user表中添加用户
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setUserName("徐浪2号");
		user.setPassword("123456");
		user.setUserId(2011014102);
		user.setRoleId(1);
		user.setAge(18);
		user.setClassId(3);
		user.setSex(1);
		UserService userService = new UserServiceImpl();
		int i = userService.doAddUser(user);
		if (i == 1) {
			System.out.println("添加成功");
		}

	}
}
