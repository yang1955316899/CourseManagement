package top.jsjkxyjs.controller;

import com.google.gson.Gson;
import top.jsjkxyjs.entity.Course;
import top.jsjkxyjs.service.impl.CourseServiceImpl;
import top.jsjkxyjs.service.impl.LocationServiceImpl;
import top.jsjkxyjs.service.impl.TeacherServiceImpl;

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

	public void getRoomUseByTime(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.getWriter().write(new Gson().toJson(new LocationServiceImpl().getRoomUseByTime(Integer.parseInt(req.getParameter("RoomId")),
				Integer.parseInt(req.getParameter("Year")),
				Integer.parseInt(req.getParameter("Semester")),
				Integer.parseInt(req.getParameter("Week")))));
	}

	public String[] getLayUICheckBoxValue(HttpServletRequest req, HttpServletResponse resp, String[] arrs) {
		String[] tem = new String[arrs.length];
		for (int index = 0; index < arrs.length; index++) {
			tem[index] = req.getParameter(arrs[index]);
		}
		return tem;
	}

	public void setCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String[] TempCode = getLayUICheckBoxValue(req, resp, new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
		String classCode = "";
		for (int index = 0; index < TempCode.length; index++) {
			if (TempCode[index] != null && !"".equals(TempCode[index])) {
				classCode += 0;
			} else {
				classCode += 1;
			}
		}
		Course course = new Course(req.getParameter("CourseName"),
				Integer.parseInt(req.getParameter("Teacher")),
				Integer.parseInt(req.getParameter("room")),
				Integer.parseInt(req.getParameter("MaxSize")),
				req.getParameter("Year") + req.getParameter("Semester"),
				Integer.parseInt(req.getParameter("Week")),
				classCode,
				Float.parseFloat(req.getParameter("Credit")),
				req.getParameter("Introduction"),
				req.getParameter("Choose") != null ? 1 : 0
		);
		resp.getWriter().write(new Gson().toJson(new CourseServiceImpl().setCourse(course)));
	}

	public void getTimeByTeacherId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.getWriter().write(new Gson().toJson(new TeacherServiceImpl().getTimeByTeacherId(req.getParameter("TeacherId")
				, req.getParameter("Year"), req.getParameter("Semester"), req.getParameter("Week"))));
	}

	public void getAllChooseCourses(HttpServletRequest req, HttpServletResponse resp) {

	}


}