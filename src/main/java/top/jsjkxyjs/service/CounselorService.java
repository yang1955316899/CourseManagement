package top.jsjkxyjs.service;

import top.jsjkxyjs.entity.Class;
import top.jsjkxyjs.entity.StudentGrade;
import top.jsjkxyjs.entity.User;

import java.util.List;

public interface CounselorService {

    /**
     * 调用此方法获取辅导员对应的班级成员信息
     *
     * @param classId 班级id
     * @return list集合
     */
    List<User> doGetClassUser(int classId);

    /**
     * 调用此方法，删除相应用户的信息
     *
     * @param userId 学生id
     * @return 删除成功信息
     */
    int doDelUser(int userId);

    /**
     * 调用此方法，批量删除用户信息
     *
     * @param a 用户列表
     * @return 删除成功信息
     */
    int doDelUserList(int[] a);


    /**
     * 增加学生用户
     *
     * @param student 学生信息
     * @return 增加成功信息
     */
    int doAddUser(User student);

    /**
     * 获取辅导员对应的班级信息
     *
     * @param userId uerId
     * @return class对象
     */
    Class doGetClass(int userId);

    /**
     * 更新单元格
     *
     * @param field 字段
     * @param value 值
     * @return 更改结果信息
     */
    int doUpdate(String field, String value, int userId);

    /**
     * 搜索用户
     *
     * @param userId   id
     * @param userName name
     * @return 结果
     */
    List<User> doSearch(int userId, String userName, int classId);

    /**
     * 获取班级学生每门课的成绩
     *
     * @param classId 班级编号
     * @return 成绩列表
     */
    List<StudentGrade> doGetGradeByClass(int classId);
}
