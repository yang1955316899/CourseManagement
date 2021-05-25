package top.jsjkxyjs.dao;

import top.jsjkxyjs.entity.StudentGrade;
import top.jsjkxyjs.entity.User;

import java.util.List;

public interface CounselorDao {
    /**
     * 调用此方法，查看班级成员信息
     **/
    List<User> viewMember(int classId);

    /**
     * 调用此方法，查看班级学生的成绩
     **/
    List<StudentGrade> viewGrade(int classId);
}
