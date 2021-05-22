package top.jsjkxyjs.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentServlet {
    public void queryMyGrade(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户的id
        String userId = req.getParameter("id");

    }

}
