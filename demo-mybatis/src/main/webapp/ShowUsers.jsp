<%@ page import="com.demo.dao.entity.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="ShowUsers">
    <table>
        <tr>
            账号<input type="text" name="accountNo"/>
            用户名<input type="text" name="userName"/>
            性别<input type="text" name="sex"/>
            <input type="submit" value="搜索"/>
        </tr>

        <tr>
            <td>页数：
                <c:forEach begin="1" end="${pageInfo.sumPages}" varStatus="num">
                    <button type="submit">${num.index}</button>
                </c:forEach>
                <!--<input type="text" name="currentPage" value="${pageInfo.currentPage}">页-->
            </td>
            <td>共 ${pageInfo.sumPages} 页</td>
            <td>共 ${pageInfo.sumCounts} 条</td>
            <td>
                <!--<input type="text" name="pageSize" value="${pageInfo.pageSize}">-->
                <select name="pageSize">
                    <option selected value="${pageInfo.pageSize}" label="${pageInfo.pageSize}">
                    </option >
                    <optgroup label="选择每页条数">
                        <option value="5">5</option>
                        <option value="10">10</option>
                        <option value="20">20</option>
                        <option value="30">30</option>
                        <option value="40">40</option>
                        <option value="50">50</option>
                    </optgroup>
                </select>
                条/页
            </td>

        </tr>
    </table>
</form>
<table border="1">
    <tr>
        <td>账号</td>
        <td>用户名</td>
        <td>性别</td>
        <td>手机号</td>
        <td>角色</td>
        <td>状态</td>
        <td>创建时间</td>
        <td>操作</td>
    </tr>
    <c:if test="${not empty userList}">
        <c:forEach items="${userList}" var="user" varStatus="vs">
            <tr>
                <td>${user.accountNo}</td>
                <td>${user.userName}</td>
                <td>
                    <c:if test="${user.sex == 0}">
                        未知
                    </c:if>
                    <c:if test="${user.sex == 1}">
                        男
                    </c:if>
                    <c:if test="${user.sex == 2}">
                        女
                    </c:if>
                </td>
                <td>${user.phone}</td>
                <td>${user.roleId}</td>
                <td>
                    <a href="UpdateStatus?id=${user.id}&status=${user.status}">
                        <c:if test="${user.status == 1}">
                            正常
                        </c:if>
                        <c:if test="${user.status == 0}">
                            锁定
                        </c:if>
                    </a>
                </td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${user.createTime}"/></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${user.updateTime}"/></td>
                <td>
                    <a href="DeleteById?id=${user.id}">删除</a>
                    <a href="QueryUser?id=${user.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<td>
    <button type="submit" ><a href="PageJump">添加用户</a></button>
</td>
</body>
</html>
