<%--
  Created by IntelliJ IDEA.
  User: denisgrebenuk
  Date: 19/10/2018
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TitleChange</title>
</head>
<body>
<form action="/changeUser" method = post>
    id: <input type="text"  name="idChange" value="${idChange}">
    <br>
    New_Name: <input type = "text" name = "nameChange" value="${nameChange}">
    <br>
    New_Age: <input type = "text" name = "ageChange" value="${ageChange}">
    <br>
    New_login: <input type="text" name="loginChange" value="${loginChange}">
    <br>
    New_password: <input type="text" name="passwordChange" value="${passwordChange}">
    <br>
    <input type = "submit" value = "Change User">
</form>
</body>
</html>
