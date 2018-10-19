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
<form action="/Change-User" method = post>
    id: <input type="text" name="id">
    New_Name: <input type = "text" name = "name">
    <br>
    New_Age: <input type = "text" name = "age">
    <br>
    <input type = "submit" value = "Change User">
</form>
</body>
</html>
