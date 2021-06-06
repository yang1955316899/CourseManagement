package top.jsjkxyjs.dao.impl;


import top.jsjkxyjs.dao.SignDao;
import top.jsjkxyjs.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignDaoImpl extends BaseDao implements SignDao {


	@Override
	public int getRoleId(User user) {
		conn = getConnection();
		String sql = "select * from t_user where UserId = ? and Password = ?";
		int roleId = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				roleId = rs.getInt("RoleId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		return roleId;
	}

	@Override
	public void signOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendRedirect("/index.html");
	}
}
