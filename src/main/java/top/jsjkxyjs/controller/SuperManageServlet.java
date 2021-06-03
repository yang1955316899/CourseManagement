package top.jsjkxyjs.controller;

import com.google.gson.Gson;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.SuperAdministratorService;
import top.jsjkxyjs.service.impl.SuperAdministratorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 超级管理员
 */
public class SuperManageServlet extends BaseServlet {
    /**
     * 获取所有用户的所有信息
     *
     * @param req  请求
     * @param resp 响应
     * @throws ServletException servlet异常
     * @throws IOException      io异常
     */
    public void getAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getAllUser方法被调用了");
        SuperAdministratorService service = new SuperAdministratorServiceImpl();
        List<User> list = service.doGetAllUser();
        System.out.println("已获取所有用户信息");
        //将list存入map中
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("code", 0);
        myMap.put("data", list);
        Gson gson = new Gson();
        String jsonListString = gson.toJson(myMap);
        resp.getWriter().write(jsonListString);
    }

    public void superSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("superSearch方法被调用了");
        String userId = req.getParameter("userId");
        int id = 0;
        if (userId != null && !"".equals(userId)) {
            id = Integer.parseInt(userId);
        }
        String userName = req.getParameter("userName");
        if (userName == null) {
            userName = "";
        }
        SuperAdministratorService service = new SuperAdministratorServiceImpl();
        List<User> list = service.doSuperSearch(id, userName);
        System.out.println("搜索完成");
        //将list存入map中
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("code", 0);
        myMap.put("data", list);
        Gson gson = new Gson();
        String jsonListString = gson.toJson(myMap);
        resp.getWriter().write(jsonListString);
    }
}
