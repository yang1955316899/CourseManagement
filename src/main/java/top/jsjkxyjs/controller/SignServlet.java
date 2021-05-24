package top.jsjkxyjs.controller;


import top.jsjkxyjs.entity.Action;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.ActionService;
import top.jsjkxyjs.service.SignService;
import top.jsjkxyjs.service.impl.ActionServiceImpl;
import top.jsjkxyjs.service.impl.SignServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SignServlet extends BaseServlet {

    /**
     * 登录的方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            resp.sendRedirect("/login.html");
        } else {
            user = signService.doGetInfo(userId);
            System.out.println("username" + user.getUserName());
            //通过roleId获取相应的actionId
            String actionId = signService.doGetActionId(roleId);
            //根据actionId获得 对应的Action对象
            ActionService actionService = new ActionServiceImpl();
            List<Action> actionsList = actionService.doGetActions(actionId);
            //获取所有子action
            List<Action> allActionsList = actionService.doGetAllActions();
            //请求转发
            req.setAttribute("user", user);
            req.setAttribute("actionsList", actionsList);
            req.setAttribute("allActionsList", allActionsList);
            req.getRequestDispatcher("/homepage.jsp").forward(req, resp);
        }
    }

    /**
     * 退出的方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void signOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignService signOut = new SignServiceImpl();
        signOut.doSignOut(req, resp);
    }
}
