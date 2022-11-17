<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 11/13/2022
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/login" method="post">
        Username: <input type="text" name="username" placeholder="Username"> <br>
        Password: <input type="password" name="password" placeholder="Password"> <br>
        <input type="submit" value="Log In"> &nbsp; <input type="reset" value="Clear">
    </form> <br>
    <c:if test="${not empty msg}">
        <label style="color: orangered">${msg}</label>
    </c:if>
</div>

</body>
</html>
