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

public class UserAddServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf8");

        String roleId = request.getParameter("roleId");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String accountNo = request.getParameter("accountNo");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");

        User user = new User();
        user.setRoleId(Integer.valueOf(roleId));
        user.setUserName(userName);
        user.setPassword(password);
        user.setAccountNo(accountNo);
        user.setSex(Integer.parseInt(sex));
        user.setPhone(phone);
        user.setStatus(1);
        user.setCreateTime(new Date());

        UserService userService = new UserService();
        User user1 = userService.selectByUsername(user);
        System.out.println(user1);
        if (user1 != null) {
            request.setAttribute("errorMsg", "该用户名已被注册");
            request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
        } else {
            int n =userService.insertUser(user);
            if(n>1){
                throw new RuntimeException("999999");
            }else if(n==0){
                request.setAttribute("errorMsg","添加失败");
                request.getRequestDispatcher("ShowUsers.jsp").forward(request,response);
            }else { //操作正确，重新查询
                user =new User();
                List<User> userList = userService.queryUserPageList(user);
                request.setAttribute("userList", userList);
                request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
            }
        }

    }
}