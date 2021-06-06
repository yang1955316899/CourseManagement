package top.jsjkxyjs.controller;

import com.google.gson.Gson;
import top.jsjkxyjs.entity.Teacher;
import top.jsjkxyjs.service.TeacherService;
import top.jsjkxyjs.service.impl.TeacherServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherServlet extends BaseServlet {

    public void getStudentsByCoureId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String courseId = req.getParameter("courseId");
        int id = 0;
        if (!"".equals(courseId) ) {
            id = Integer.parseInt(courseId);
        }

        TeacherService teacherService = new TeacherServiceImpl();
        List<Teacher> list = teacherService.getStudentsByCourseId(id);
        //将list存入map中
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("code", 0);
        myMap.put("data", list);
        Gson gson = new Gson();
        String jsonListString = gson.toJson(myMap);
        resp.getWriter().write(jsonListString);
    }

    public void getCourseByTeacherId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write(new Gson().toJson(new TeacherServiceImpl().getCourseByTeacherId(Integer.parseInt(req.getParameter("TeacherId")))));
    }

    public void upDateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String StudentId = req.getParameter("StudentId");
        String  Grade = req.getParameter("newGrade");

        int i = 0,j =0;
        if (StudentId != null && !"".equals(StudentId)){
           j = Integer.parseInt(StudentId);
        }
        if (Grade != null && !"".equals(Grade)){
            i = Integer.parseInt(Grade);
        }
        TeacherService teacherService = new TeacherServiceImpl();
        teacherService.updateStudent1(i,j);
//        Map<String, Object> myMap = new HashMap<>();
//        myMap.put("code", 0);
//        Gson gson = new Gson();
//        String jsonListString = gson.toJson(myMap);
//        resp.getWriter().write(jsonListString);

    }
}
