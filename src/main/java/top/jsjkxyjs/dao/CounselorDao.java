package top.jsjkxyjs.dao;

import top.jsjkxyjs.entity.User;

import java.util.List;

public interface CounselorDao {
	List<User> viewMember(int classId);
}
