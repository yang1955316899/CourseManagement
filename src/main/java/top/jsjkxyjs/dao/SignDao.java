package top.jsjkxyjs.dao;


import top.jsjkxyjs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface SignDao {
    int getRoleId(User user);

    void signOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
