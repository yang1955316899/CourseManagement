package top.jsjkxyjs.controller;

import com.google.gson.Gson;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.PersonalService;
import top.jsjkxyjs.service.impl.PersonalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 个人中心
 *
 * @author SeRein
 */
public class PersonalServlet extends BaseServlet {
    /**
     * 修改密码
     *
     * @param req  请求
     * @param resp 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    public void changePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonalService service = new PersonalServiceImpl();
        int i = service.doChangePassword(Integer.parseInt(req.getParameter("userId"))
                , req.getParameter("newPassword"));
        Map<String, Integer> map = new HashMap<>();
        map.put("result", i);
        Gson gson = new Gson();
        String gsonStr = gson.toJson(map);
        resp.getWriter().write(gsonStr);

    }


    /**
     * 修改个人信息
     *
     * @param req  请求
     * @param resp 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    public void changeMyInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setUserId(Integer.parseInt(req.getParameter("userId")));
        user.setSex(Integer.parseInt(req.getParameter("sex")));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        PersonalService service = new PersonalServiceImpl();
        int i = service.doChangeMyInfo(user);
        Map<String, Integer> map = new HashMap<>();
        map.put("result", i);
        Gson gson = new Gson();
        String gsonStr = gson.toJson(map);
        resp.getWriter().write(gsonStr);
    }

    /**
     * 判断旧密码是否正确
     *
     * @param req  请求
     * @param resp 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    public void ifCorrect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonalService service = new PersonalServiceImpl();
        String userId = req.getParameter("userId");
        if (userId == null) {
            System.out.println("userId为空");
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("result", service.doIfCorrect(Integer.parseInt(req.getParameter("userId")), req.getParameter("oldPassword")));
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(map));
    }

}
