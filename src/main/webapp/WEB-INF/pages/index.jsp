<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 11/13/2022
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<c:if test="${not empty msg}">
    <label style="color: orangered">${msg}</label>
</c:if>
${customerList}

<a href="${pageContext.request.contextPath}/newCustomer"><input type="button" value="New"></a>

<table border="1" style="width: 100px;">
    <tr>
        <th>#</th>
        <th>Username</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Date of birth</th>
        <th>Phone</th>
        <th>Cif</th>
        <th>Pin</th>
        <th>Seria</th>
    </tr>

    <c:forEach items="${customerList}" var="cl">
        <tr>
            <td>${cl.customerId}</td>
            <td>${cl.username}</td>
            <td>${cl.name}</td>
            <td>${cl.surname}</td>
            <td>${cl.dob}</td>
            <td>${cl.phone}</td>
            <td>${cl.cif}</td>
            <td>${cl.pin}</td>
            <td>${cl.seria}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
