<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>更新数据</title>
</head>
<body>
<form action="UpdateById">
    <input type="hidden" value="${user.id}" name="id" />
    <table border="1">
        <tr>
            <td>账号</td>
            <td><input type="text" name="accountNo" value="${user.accountNo}" /></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td>
            <input type="text" name="userName" value="${user.userName}"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="1">男
                <input type="radio"  name="sex" value="2">女
                <input type="radio"  name="sex" value="0" >未知
                <script language= JavaScript>
                    function initradio(rName,rValue){
                        var rObj = document.getElementsByName(rName);
                        for(var i = 0;i < rObj.length;i++){
                            if(rObj[i].value == rValue){
                                rObj[i].checked =  'checked';
                            }
                        }
                    }
                    var s="${user.sex}";//这里传入什么值就设为默认值。
                    initradio('sex',s);  //调用js方法来实现动态改变默认值
                </script>
            </td>
        </tr>
        <tr>
            <td>手机号</td>
            <td><input type="text"  name="phone" value="${user.phone}"/></td>
        </tr>
        <tr><td>角色</td>
            <td><input type="text" name="roleId" value="${user.roleId}"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
