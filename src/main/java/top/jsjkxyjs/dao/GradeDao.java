package top.jsjkxyjs.dao;


import top.jsjkxyjs.entity.StudentGrade;

import java.util.List;

public interface GradeDao {
	/**
	 * 通过学生id 获取其相应的成绩
	 */
	List<StudentGrade> getGradeById(int id);
}
