package top.jsjkxyjs.dao.impl;

import top.jsjkxyjs.dao.SuperAdministratorDao;
import top.jsjkxyjs.entity.User;

import java.util.ArrayList;
import java.util.List;

public class SuperAdministratorDaoImpl extends BaseDao implements SuperAdministratorDao {
    /**
     * 获取所有用户信息
     *
     * @return 用户信息列表
     */
    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        conn = getConnection();
        String sql = "select * from t_user where state=1";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setSex(rs.getInt("sex"));
                user.setAge(rs.getInt("age"));
                user.setRoleId(rs.getInt("roleId"));
                user.setPassword(rs.getString("password"));
                user.setClassId(rs.getInt("classId"));
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
     * 超级管理员搜索
     *
     * @param userId   用户Id
     * @param userName 用户name
     * @return 用户列表
     */
    @Override
    public List<User> superSearch(int userId, String userName) {
        List<User> list = new ArrayList<>();
        conn = getConnection();
        String sql;
        if (userId != 0 && !"".equals(userName)) {
            sql = "select * from t_user where (userId = ? and userName = ?) and state=1";
        } else if (userId == 0 && "".equals(userName)) {
            sql = "select * from t_user where (userId = ? or userName = ? ) or  state=1";
        } else {
            sql = "select * from t_user where (userId = ? or userName = ? ) and state=1";
        }

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getInt("sex"));
                user.setClassId(rs.getInt("classId"));
                user.setRoleId(rs.getInt("roleId"));
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
     * 管理员添加用户
     *
     * @param user user
     * @return 结果信息
     */
    @Override
    public int superAddUser(User user) {
        int i = 0;
        conn = getConnection();
        String sql = "insert into t_user (userId,userName,password,age,sex,roleId,classId) values(?,?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getAge());
            ps.setInt(5, user.getSex());
            ps.setInt(6, user.getRoleId());
            ps.setInt(7, user.getClassId());
            i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }
        return i;
    }

    /**
     * 根据班级name获取班级id
     *
     * @param className 班级名字
     * @return 班级id
     */
    @Override
    public int getClassIdByClassName(String className) {
        int classId = 0;
        conn = getConnection();
        String sql = "select id from t_class where className=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, className);
            rs = ps.executeQuery();
            if (rs.next()) {
                classId = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, conn);
        }

        return classId;
    }
}
