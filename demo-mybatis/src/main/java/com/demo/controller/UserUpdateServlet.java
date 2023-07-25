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

public class UserUpdateServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf8");

        String id = request.getParameter("id");
        if (id == null || id.equals("")) {                                   //判断id是否非空
            request.setAttribute("errorMsg","id can not be null!");
            request.getRequestDispatcher("UserManage.jsp").forward(request,response);
            return;
        }
        String accountNo = request.getParameter("accountNo");
        String userName = request.getParameter("userName");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String roleId = request.getParameter("roleId");


        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setAccountNo(accountNo);
        user.setUserName(userName);
        user.setSex(Integer.parseInt(sex));
        user.setPhone(phone);
        user.setRoleId(Integer.parseInt(roleId));
        user.setUpdateTime(new Date());


        UserService userService = new UserService();
        int n =userService.updateById(user);
        if(n>1){
            throw new RuntimeException("999999");
        }else if(n==0){
            request.setAttribute("errorMsg","状态已经是这个值了，操作有误");
            request.getRequestDispatcher("ShowUsers.jsp").forward(request,response);
        }else { //操作正确，重新查询
            user =new User();
            List<User> userList = userService.queryUserPageList(user);
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
        }
    }
}