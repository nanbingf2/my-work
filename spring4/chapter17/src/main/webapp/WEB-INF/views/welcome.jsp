<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2018/4/23
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WelCome</title>
</head>
<body>
request作用域中的user对象:${user.userName}<br>
session作用域中的user对象:${sessionScope.user.userName}<br>
</body>
</html>
