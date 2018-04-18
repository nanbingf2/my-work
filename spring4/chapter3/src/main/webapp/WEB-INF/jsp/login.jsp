<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2018/4/9
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${!empty error}">
        <font color="red"><c:out value="${error}"></c:out></font>
    </c:if>
    <form action="loginCheck.html" method="post">
        用户名:
        <input type="text" name="userName">
        <br>
        密码:
        <input type="password" name="password"/>
        <br>
        <input type="submit" value="登录"/>
        <input type="reset" vlaue="重置"/>
    </form>
</body>
</html>
