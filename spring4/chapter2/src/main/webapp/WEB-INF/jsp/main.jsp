<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2018/4/11
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Spring论坛</title>
</head>
<body>
    ${user.userName},欢迎你进入Spring论坛,您当前的积分为${user.credits}
</body>
</html>
