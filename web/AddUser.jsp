<%--
  Created by IntelliJ IDEA.
  User: denisgrebenuk
  Date: 19/10/2018
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddUser</title>
</head>
<body>
<form action="/Add-User" method = post>
    Name: <input type = "text" name = "name">
    <br>
    <br>
    Age: <input type = "text" name = "age">
    <br>
    <br>
    login: <input type="text", name="login">
    <br>
    <br>
    pass: <input type="text", name="password">
    <br>
    <br>
    Role: <input type="text", name="role">
    <br>
    <input type = "submit" value = "Add User">
</form>
</body>
</html>
