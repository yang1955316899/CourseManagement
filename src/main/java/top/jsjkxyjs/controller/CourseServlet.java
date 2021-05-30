package top.jsjkxyjs.controller;

import com.google.gson.Gson;
import top.jsjkxyjs.service.impl.LocationServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CourseServlet extends BaseServlet {
    public void getAllLocation(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(new Gson().toJson(new LocationServiceImpl().getLocation()));
    }

    public void getRoomByLocationId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(new Gson().toJson(new LocationServiceImpl().getRoomByLocationId(Integer.parseInt(req.getParameter("location")))));
    }

    public void getMaxSizeById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(new Gson().toJson(new LocationServiceImpl().getmaxSizeById(Integer.parseInt(req.getParameter("roomId")))));
    }
}