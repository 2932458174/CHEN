package com.demo.controller;

import com.demo.dao.entity.User;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserDeleteServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");

        UserService userService = new UserService();
        try {
            String id = request.getParameter("id");//获取id
            if (id == null) {
                request.setAttribute("errorMsg", "id can not be null");//如果id为空，提示失败
                return;
            }
            User user = new User();
            user.setId(Integer.parseInt(id));//数据类型转换
            int i = userService.deleteById(user);
            if (i != 1) {
                request.setAttribute("errorMsg", "delete id fail !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            List<User> users = userService.queryUserPageList(new User());//查询数据
            request.setAttribute("userList", users);
            request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
        }

    }
}
