package top.jsjkxyjs.controller;

import com.google.gson.Gson;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.CounselorService;
import top.jsjkxyjs.service.impl.CounselorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CounselorServlet extends BaseServlet {
	/**
	 * 调用此方法，得到辅导员对应班级成员信息
	 *
	 * @param req  请求
	 * @param resp 响应
	 * @throws ServletException servlet异常
	 * @throws IOException      io异常
	 */
	public void getClassUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("getClassUser方法被访问了");
		int classId = 1;/*Integer.parseInt(req.getParameter("classId"));*/
		CounselorService service = new CounselorServiceImpl();
		List<User> list = service.doGetClassUser(classId);
		System.out.println("用户列表查询完成");
		//将list存入map中
		Map<String, Object> myMap = new HashMap<>();
		myMap.put("code", 0);
		myMap.put("msg", "");
		myMap.put("count", 35);
		myMap.put("limit", 10);
		myMap.put("data", list);
		Gson gson = new Gson();
		String jsonListString = gson.toJson(myMap);
		resp.getWriter().write(jsonListString);
	}


	public void delUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("del方法被执行了");
		CounselorService service = new CounselorServiceImpl();
		int i = service.doDelUser(Integer.parseInt(req.getParameter("userId")));
		System.out.println("del执行结果i=" + i);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", i);
		Gson gson = new Gson();
		String gsonStr = gson.toJson(map);
		resp.getWriter().write(gsonStr);
	}

	/**
	 * 删除uerId列表对应的用户信息
	 *
	 * @param req  请求
	 * @param resp 响应
	 * @throws ServletException servlet异常
	 * @throws IOException      io异常
	 */
	public void delUserList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delUserList方法被执行了");
		//获取发送过来的数组，并将数组里面的每一项都转换为int类型
		String a = req.getParameter("a");
		System.out.println(a);
		String[] b = a.split(",");

		int[] idArr = new int[b.length];
		for (int i = 0; i < b.length; i++) {
			idArr[i] = Integer.parseInt(b[i]);
			System.out.println(idArr[i]);
		}
		//调用方法执行删除操作，并返回成功信息
		CounselorService service = new CounselorServiceImpl();
		int i = service.doDelUserList(idArr);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", i);
		System.out.println("删除条数" + i);
		Gson gson = new Gson();
		String gsonStr = gson.toJson(map);
		resp.getWriter().write(gsonStr);
	}

	/**
	 * 向班级中添加学生
	 *
	 * @param req  请求
	 * @param resp 响应
	 * @throws ServletException servlet异常
	 * @throws IOException      io异常
	 */
	public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("addStudent方法被调用");
		User student = new User();
		student.setUserId(Integer.parseInt(req.getParameter("userId")));
		student.setUserName(req.getParameter("userName"));
		student.setSex(Integer.parseInt(req.getParameter("sex")));
		student.setAge(Integer.parseInt(req.getParameter("age")));
		student.setPassword(req.getParameter("password"));
		student.setClassId(Integer.parseInt(req.getParameter("classId")));

		CounselorService service = new CounselorServiceImpl();
		int i = service.doAddUser(student);
		if (i == 1) {
			System.out.println("添加学生" + student.getUserName() + "成功");
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("result", i);
		Gson gson = new Gson();
		String gsonStr = gson.toJson(map);
		resp.getWriter().write(gsonStr);
	}

	public void upDateTable(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("upDate方法被调用");
		String field = req.getParameter("field");
		String value = req.getParameter("value");
		int userId = Integer.parseInt(req.getParameter("userId"));
		CounselorService service = new CounselorServiceImpl();
		int i = service.doUpdate(field, value, userId);
		System.out.println("更新结果i=" + i);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", i);
		Gson gson = new Gson();
		String gsonStr = gson.toJson(map);
		resp.getWriter().write(gsonStr);
	}

	public void searchUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("search方法被调用");
		String userId = req.getParameter("userId");
		int id = 0;
		if (userId == null) {
			id = 0;
		} else {
			id = Integer.parseInt(userId);
		}
		String userName = req.getParameter("userName");
		if (userName == null) {
			userName = "";
		}
		CounselorService service = new CounselorServiceImpl();
		int i = service.doSearch(id, userName);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", i);
		Gson gson = new Gson();
		String gsonStr = gson.toJson(map);
		resp.getWriter().write(gsonStr);
	}
}
