package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.CounselorDao;
import top.jsjkxyjs.dao.impl.CounselorDaoImpl;
import top.jsjkxyjs.entity.Class;
import top.jsjkxyjs.entity.Grade;
import top.jsjkxyjs.entity.SC;
import top.jsjkxyjs.entity.User;
import top.jsjkxyjs.service.CounselorService;

import java.util.ArrayList;
import java.util.List;

public class CounselorServiceImpl implements CounselorService {

    /**
     * 调用此方法获取辅导员对应的班级成员信息
     *
     * @param classId 班级id
     * @return list集合
     */
    @Override
    public List<User> doGetClassUser(int classId) {
        CounselorDao dao = new CounselorDaoImpl();
        return dao.getClassUser(classId);
    }

    /**
     * 调用此方法，删除相应用户的信息
     *
     * @param userId 学生id
     * @return 删除成功信息
     */
    @Override
    public int doDelUser(int userId) {
        CounselorDao dao = new CounselorDaoImpl();
        return dao.delUser(userId);
    }

    @Override
    public int doDelUserList(int[] a) {
        CounselorDao dao = new CounselorDaoImpl();
        return dao.delUserList(a);
    }

    /**
     * 增加学生用户
     *
     * @param student 学生信息
     * @return 增加成功信息
     */
    @Override
    public int doAddUser(User student) {
        CounselorDao dao = new CounselorDaoImpl();
        return dao.addUser(student);
    }

    /**
     * 获取辅导员对应的班级信息
     *
     * @param userId uerId
     * @return class对象
     */
    @Override
    public Class doGetClass(int userId) {
        CounselorDao dao = new CounselorDaoImpl();
        return dao.getMyClass(userId);
    }

    /**
     * 更新单元格
     *
     * @param field 字段
     * @param value 值
     * @return 更改结果信息
     */
    @Override
    public int doUpdate(String field, String value, int userId) {
        CounselorDao dao = new CounselorDaoImpl();
        return (dao.updateTable(field, value, userId));
    }

    /**
     * 搜索用户
     *
     * @param userId   id
     * @param userName name
     * @return 结果
     */
    @Override
    public List<User> doSearch(int userId, String userName, int classId) {
        CounselorDao dao = new CounselorDaoImpl();
        return dao.searchUser(userId, userName, classId);
    }


    /**
     * 获取班级学生每门课的成绩
     *
     * @param classId 班级编号
     * @return 成绩列表
     */
    @Override
    public List<User> doGetGradeByClass(int classId) {
        CounselorDao dao = new CounselorDaoImpl();
        //获取班级所有学生信息,包含userId和userName
        List<User> userList = dao.getClassUser(classId);
        //获取最大课程数
        int max = 0;
        //对所有学生依次获取其课程成绩
        for (int i = 0; i < userList.size(); i++) {//获取每个学生的userId
            int userId = userList.get(i).getUserId();
            //通过userId获取grade和courseId
            List<SC> scList = dao.getScByUserId(userId);
            if (scList.size() > max) {
                max = scList.size();
            }
            //通过courseId获取courseName
            List<String> courseNameList = new ArrayList<>();
            for (int j = 0; j < scList.size(); j++) {
                int courseId = scList.get(j).getCourseId();
                courseNameList.add(dao.getCourseNameById(courseId));
            }
            for (int j = 0; j < scList.size(); j++) {
                Grade grade = new Grade();
                grade.setCourseName(courseNameList.get(j));
                int scGrade = scList.get(j).getGrade();
                grade.setGrade(scGrade);
                userList.get(i).gradeList.add(grade);
            }
        }
        return userList;
    }
}

