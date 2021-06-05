package top.jsjkxyjs.controller;

import top.jsjkxyjs.entity.Action;
import top.jsjkxyjs.entity.Class;
import top.jsjkxyjs.entity.StudentGrade;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.ActionService;
import top.jsjkxyjs.service.CounselorService;
import top.jsjkxyjs.service.SignService;
import top.jsjkxyjs.service.impl.ActionServiceImpl;
import top.jsjkxyjs.service.impl.CounselorServiceImpl;
import top.jsjkxyjs.service.impl.SignServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SignServlet extends BaseServlet {
	/**
	 * 登录的方法
	 */
	public void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("signIn方法被访问了");
		//获取发送过来的 userId和password并封装成user对象
		int userId = Integer.parseInt(req.getParameter("userId"));
		String password = req.getParameter("password");
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);

		//通过use对象获取roleId,如果roelId等于0,则用户名密码不正确
		SignService signService = new SignServiceImpl();
		int roleId = signService.doSignIn(user);
		if (roleId == 0) {
			System.out.println("登录失败");
			resp.sendRedirect("/index.html");
		} else {

			//通过 userId获取user对象的全部信息
			user = signService.doGetInfo(userId);
			System.out.println(user.getUserName() + "登录成功");
			//通过roleId获取相应的actionId
			String actionId = signService.doGetActionId(roleId);

			//根据actionId获得 对应的Action对象
			ActionService actionService = new ActionServiceImpl();
			List<Action> actionsList = actionService.doGetActions(actionId);

			//获取所有子action
			List<Action> allActionsList = actionService.doGetAllActions();

			//装箱并请求转发
			HttpSession session = req.getSession();
			//如果用户带有班级，则获取所带的班级id 和学生成绩信息
			if (roleId == 3 || roleId == 5) {
				CounselorService service = new CounselorServiceImpl();
				Class myClass = service.doGetClass(userId);
				List<StudentGrade> gradeList = service.doGetGradeByClass(myClass.getId());
				session.setAttribute("gradesList", gradeList);
				session.setAttribute("myClass", myClass);
			}
			session.setAttribute("user", user);
			req.setAttribute("actionsList", actionsList);
			req.setAttribute("allActionsList", allActionsList);
			req.getRequestDispatcher("pages/home.jsp").forward(req, resp);
		}
	}

	/**
	 * 退出的方法
	 */
	public void signOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SignService signOut = new SignServiceImpl();
		signOut.doSignOut(req, resp);
	}
}
