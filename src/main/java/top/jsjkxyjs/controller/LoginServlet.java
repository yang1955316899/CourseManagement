package top.jsjkxyjs.controller;


import top.jsjkxyjs.entity.Action;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.ActionService;
import top.jsjkxyjs.service.LoginService;
import top.jsjkxyjs.service.RoleService;
import top.jsjkxyjs.service.impl.ActionServiceImpl;
import top.jsjkxyjs.service.impl.LoginServiceImpl;
import top.jsjkxyjs.service.impl.RoleServceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends BaseServlet {
    public void loginJudge(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取发送过来的 userId和password并封装成user对象
        int userId = Integer.parseInt(req.getParameter("userId"));
        String password = req.getParameter("password");
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);

        //通过use对象获取roleId,如果roelId等于0,则用户名密码不正确
        LoginService loginService = new LoginServiceImpl();
        int roleId = loginService.doLogin(user);
        if (roleId == 0) {
            resp.sendRedirect("/login.html");
        } else {
            //通过roleId获取相应的actionId
            RoleService roleService = new RoleServceImpl();
            String roleActionId = roleService.doGetActionIdByRoleId(roleId);

            //根据actionId获得 对应的Action对象
            ActionService actionService = new ActionServiceImpl();
            List<Action> actionsList = actionService.doGetActions(roleActionId);


            //请求转发
            req.setAttribute("actionsList", actionsList);
            req.getRequestDispatcher("/homepage.jsp").forward(req, resp);

        }

    }
}
