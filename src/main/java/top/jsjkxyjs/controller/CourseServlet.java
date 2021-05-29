package top.jsjkxyjs.controller;

import top.jsjkxyjs.service.impl.LocationServiceImpl;

import java.util.List;

public class CourseServlet extends BaseServlet {
	public List<String> getAllLocation() {
		return new LocationServiceImpl().getLocation();
	}
}
