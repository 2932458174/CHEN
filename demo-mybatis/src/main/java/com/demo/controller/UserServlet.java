package com.demo.controller;

import com.demo.dao.entity.User;
import com.demo.service.UserService;
import com.demo.vo.PageInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class UserServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");

        //默认当前页
        int pageCurrent = 1;
        //默认总行数
        int pageSize = 10;
        String pageCurrentstr = request.getParameter("pageCurrent");
        if (pageCurrentstr != null && !pageCurrentstr.equals("")) {
            pageCurrent= Integer.parseInt(pageCurrentstr);
        }
        String pageSizestr = request.getParameter("pageSize");
        if (pageSizestr != null && !pageSizestr.equals("")) {
            pageSize = Integer.parseInt(pageSizestr);
        }

        User user = new User();
        String accountNo = request.getParameter("accountNo");
        if (accountNo != null && !accountNo.equals("")) {
            user.setAccountNo(accountNo);
        }
        String username = request.getParameter("userName");
        if (accountNo != null && !accountNo.equals("")) {
            user.setUserName(username);
        }
        String sex = request.getParameter("sex");
        if (accountNo != null && !accountNo.equals("")) {
            user.setSex(Integer.valueOf(sex));
        }
        //条件查询用户信息
        UserService userService = new UserService();
        List<User> users = userService.queryUserPageList(user);


        //总条数
        int sumCounts = users.size();
        //总页数
        int sumPages = sumCounts / pageSize +( sumCounts % pageSize == 0 ? 0 : 1);
        //起始下标
        int startIndex = (pageCurrent - 1) * pageSize;
        //结束下标
        int endIndex = pageCurrent * pageSize - 1;
        //返回用户分页信息
        List<User> returnUserList = new ArrayList<>();

        if (users.size() > 0) {
            for (int i = 0; i < users.size(); i++) {
                if (i >= startIndex && i <= endIndex) {
                    returnUserList.add(users.get(i));
                }
            }
        }

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageCurrent(pageCurrent);
        pageInfo.setPageSize(pageSize);
        pageInfo.setSumCounts(sumCounts);
        pageInfo.setSumPages(sumPages);

        request.setAttribute("pageInfo",pageInfo);
        request.setAttribute("userList",returnUserList);
        request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
    }

}