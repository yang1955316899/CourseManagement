package top.jsjkxyjs.service;


import top.jsjkxyjs.entity.StudentGrade;

import java.util.List;

public interface StudentService {

	/**
	 * 通过学生 id 查询相应学生的成绩
	 */
	List<StudentGrade> doGetGradeById(int id);
}
