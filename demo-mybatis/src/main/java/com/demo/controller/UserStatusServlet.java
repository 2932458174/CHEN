package com.demo.controller;

import com.demo.dao.entity.User;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class UserStatusServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        if (id == null && !id.equals("")) {
            request.setAttribute("errorMsg", "id can not be null");
            request.getRequestDispatcher("showUsers.jsp").forward(request, response);
            return ;
        }
        String status = request.getParameter("status");
        if (status == null && !status.equals("")) {
            request.setAttribute("errorMsg", "id can not be null");
            request.getRequestDispatcher("showUsers.jsp").forward(request, response);
            return ;
        }


        User user = new User();
        user.setId(Integer.parseInt(id));
        Integer istatus = Integer.parseInt(status);
        if (istatus.equals(0)) {
            user.setStatus(1);
        } else {
            user.setStatus(0);
        }
        user.setUpdateTime(new Date());
        UserService userService = new UserService();
        int i = userService.updateStatus(user);
        if (i > 1) {
            throw new RuntimeException("9999");
        } else if (i == 0) {
            request.setAttribute("errorMsg", "status is this value");
            request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
            return;
        } else {
            user = new User();
            List<User> userList = userService.queryUserPageList(user);
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
        }

    }

}