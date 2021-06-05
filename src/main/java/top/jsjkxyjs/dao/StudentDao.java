package top.jsjkxyjs.dao;

import java.util.List;

public interface StudentDao {


	List<String> getTimeByUserId(int UserId, int year, int semester, int day);
}
