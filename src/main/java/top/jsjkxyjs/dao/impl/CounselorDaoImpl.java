package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.CounselorDao;
import top.jsjkxyjs.entity.Class;
import top.jsjkxyjs.entity.SC;
import top.jsjkxyjs.entity.User;

import java.util.ArrayList;
import java.util.List;

public class CounselorDaoImpl extends BaseDao implements CounselorDao {

    /**
     * 根据班级id 查看相应班级的学生成员信息
     **/
    @Override
    public List<User> getClassUser(int classId) {
        List<User> list = new ArrayList<>();
        conn = getConnection();
        String sql = "select * from t_user where roleId=4 and classId=? and state=1";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, classId);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getInt("sex"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return list;
    }

    /**
     * 调用此方法，删除相应学生的信息
     *
     * @param userId 学生id
     * @return 删除成功信息
     */
    @Override
    public int delUser(int userId) {
        int i = 0;
        conn = getConnection();
        String sql = "update t_user set state = 0 where userId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return i;
    }

    /**
     * 调用此方法删除userIdlist中对应的user
     *
     * @param a uerId数组
     * @return 删除成功信息
     */
    @Override
    public int delUserList(int[] a) {
        int i = 0;
        conn = getConnection();
        StringBuilder sql = new StringBuilder("update t_user set state=0 where userId=");
        //拼接成完整sql语句
        for (int j = 0; j < a.length; j++) {
            if (j != a.length - 1) {
                sql.append("? or userId=");
            } else {
                sql.append("?");
            }
        }

        try {
            ps = conn.prepareStatement(String.valueOf(sql));
            for (int j = 0; j < a.length; j++) {
                ps.setInt(j + 1, a[j]);
            }
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return i;
    }

    /**
     * 调用此方法添加学生到班级
     *
     * @param student User对象
     * @return 添加成功信息
     */
    @Override
    public int addUser(User student) {
        int i = 0;
        conn = getConnection();
        String sql = "insert into t_user (userId,userName,password,age,sex,classId,roleId) values(?,?,?,?,?,?,4)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, student.getUserId());
            ps.setString(2, student.getUserName());
            ps.setString(3, student.getPassword());
            ps.setInt(4, student.getAge());
            ps.setInt(5, student.getSex());
            ps.setInt(6, student.getClassId());
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return i;
    }


    /**
     * 获取辅导员所对应的classId
     *
     * @param userId userID
     * @return classId
     */
    @Override
    public Class getMyClass(int userId) {
        Class myClass = new Class();
        conn = getConnection();
        String sql = "select t_class.id,t_class.Classname " +
                "from t_user,t_class " +
                "where t_user.userId = t_class.Counselor " +
                "and userId=?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                myClass.setClassName(rs.getString("className"));
                myClass.setId(rs.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return myClass;
    }

    /**
     * 修改单元格的值
     *
     * @param field 字段
     * @return 修改结果信息
     */
    @Override
    public int updateTable(String field, String value, int userId) {
        conn = getConnection();
        int i = 0;
        String sql = "update t_user set " + field + "=? where userId=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, value);
            ps.setInt(2, userId);
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }

        return i;
    }

    /**
     * 搜索用户
     *
     * @param userId   用户id
     * @param userName 用户名
     * @return 搜索结果信息
     */
    @Override
    public List<User> searchUser(int userId, String userName, int classId) {
        List<User> list = new ArrayList<>();
        conn = getConnection();
        String sql;
        if (userId != 0 && !userName.equals("")) {
            sql = "select * from t_user where userId = ? and userName=? and classId=? and roleId=4 and state=1";
        } else if (userId == 0 && "".equals(userName)) {
            sql = "select * from t_user where (userId = ? or userName=? or classId = ?) and roleId=4 and state=1";
        } else {
            sql = "select * from t_user where (userId = ? or userName=?) and classId=? and roleId=4 and state=1";
        }

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, userName);
            ps.setInt(3, classId);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getInt("sex"));
                user.setClassId(rs.getInt("classId"));
                user.setRoleId(4);
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return list;
    }

    /**
     * 获取对应学生的课程SC
     *
     * @param userId userId
     * @return 成绩集合
     */
    @Override
    public List<SC> getScByUserId(int userId) {
        List<SC> list = new ArrayList<>();
        conn = getConnection();
        String sql = "select t_user.userName,courseId,grade from t_sc,t_user where t_user.userId = t_sc.studentId and userId=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                SC sc = new SC();
                sc.setCourseId(rs.getInt("courseId"));
                sc.setGrade(rs.getInt("grade"));
                list.add(sc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return list;
    }

    /**
     * 获取课程名称
     *
     * @param courseId 课程id
     * @return 课程名称
     */
    @Override
    public String getCourseNameById(int courseId) {
        String courseName = "";
        conn = getConnection();
        String sql = "select courseName from t_course where id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, courseId);
            rs = ps.executeQuery();
            if (rs.next()) {
                courseName = rs.getString("courseName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return courseName;
    }
}
