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
		int location = Integer.parseInt(req.getParameter("location"));
		resp.getWriter().write(new Gson().toJson(new LocationServiceImpl().getRoomByLocationId(location)));
	}
}