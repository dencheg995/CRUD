<%--
  Created by IntelliJ IDEA.
  User: denisgrebenuk
  Date: 24/10/2018
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/register" method="post">
    Ваше имя: <input type="text", name="name">
    <br>
    <br>
    Ваш возраст: <input type="text", name="age">
    <br>
    <br>
    Придумайте логин: <input type="text", name="login">
    <br>
    <br>
    Придумайте пароль: <input type="text", name="password">
    <br>
    <input type="submit", value="Зарегистрироваться">
</form>
</body>
</html>
