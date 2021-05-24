package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.GradeDao;
import top.jsjkxyjs.entity.StudentGrade;
import top.jsjkxyjs.util.BaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class GradeDaoImpl implements GradeDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	BaseUtil util = new BaseUtil();

	/**
	 * 通过学生id 获取其相应的成绩
	 */
	@Override
	public List<StudentGrade> getGradeById(int id) {

		conn = util.getConnection();
		String sql = "";

		return null;
	}
}
