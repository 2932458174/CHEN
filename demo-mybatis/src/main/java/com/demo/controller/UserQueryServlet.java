package com.demo.controller;

import com.demo.dao.entity.User;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserQueryServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf8");

        String id = request.getParameter("id");
        if (id == null || id.equals("")) {         //判断id是否非空
            request.setAttribute("errorMsg","id can not be null!");
            request.getRequestDispatcher("ShowUsers.jsp").forward(request,response);
            return;
        }

        UserService userService = new UserService();
        User user  = userService.queryUser(Integer.parseInt(id));
        request.setAttribute("user",user);
        request.getRequestDispatcher("UpdateById.jsp").forward(request, response);

    }
}