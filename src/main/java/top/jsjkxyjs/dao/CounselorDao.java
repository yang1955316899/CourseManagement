package top.jsjkxyjs.dao;

import top.jsjkxyjs.entity.Class;
import top.jsjkxyjs.entity.StudentGrade;
import top.jsjkxyjs.entity.User;

import java.util.List;

public interface CounselorDao {
    /**
     * 调用此方法，查看班级成员信息
     **/
    List<User> getClassUser(int classId);


    /**
     * 调用此方法，删除相应学生的信息
     *
     * @param userId 学生id
     * @return 删除成功信息
     */
    int delUser(int userId);

    /**
     * 调用此方法删除userIdlist中对应的user
     *
     * @param a uerId数组
     * @return 删除成功信息
     */
    int delUserList(int[] a);


    /**
     * 调用此方法添加学生到班级
     *
     * @param student User对象
     * @return 添加成功信息
     */
    int addUser(User student);

    /**
     * 获取辅导员所对应的classId
     *
     * @param userId userID
     * @return class对象
     */
    Class getMyClass(int userId);

    /**
     * 修改单元格的值
     *
     * @param field 字段
     * @return 修改结果信息
     */
    int updateTable(String field, String value, int userId);

    /**
     * 搜索用户
     *
     * @param userId   用户id
     * @param userName 用户名
     * @return 搜索结果信息
     */
    List<User> searchUser(int userId, String userName, int classId);


    /**
     * 获取班级学生的成绩信息
     *
     * @param classId 班级号
     * @return 学生成绩列表
     */
    List<StudentGrade> getGradesByClass(int classId);

}
