<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 11/17/2022
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Customer</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.6.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<label class="lblDesign">Username : </label><input type="text" id="usernameId" placeholder="Username">
<label class="lblDesign">Password : </label> <input type="text" id="passwordId" placeholder="Password">
<label class="lblDesign">Name : </label> <input type="text" id="nameId" placeholder="Name">
<label class="lblDesign">Surname : </label> <input type="text" id="surnameId" placeholder="Surname">
<label class="lblDesign">Date of birth : </label> <input type="text" id="dobId" placeholder="Date of birth">
<label class="lblDesign">Address : </label> <input type="text" id="addressId" placeholder="Address">
<label class="lblDesign">Phone : </label> <input type="text" id="phoneId" placeholder="Phone">
<label class="lblDesign">Cif : </label> <input type="text" id="cifId" placeholder="Cif">
<label class="lblDesign">Pin : </label> <input type="text" id="pinId" placeholder="Pin">
<label class="lblDesign">Seria : </label> <input type="text" id="seriaId" placeholder="Seria">
<input type="button" id="addBtnId" value="Add"/> &nbsp; <input type="button" id="clearBtnId" value="Clear"/>


</body>
</html>
