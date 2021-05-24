package top.jsjkxyjs.service;


import top.jsjkxyjs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface SignService {
	int doSignIn(User user);

	void doSignOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

	String doGetActionId(int roleId);

	User doGetInfo(int userId);
}
