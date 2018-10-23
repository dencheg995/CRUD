

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>TITLE</title>

<body>
<h1>HELLO!</h1>
<div>
    <form action="/filter" method="post">
        Login: <input type="text", name="login">
        Password: <input type="text", name="password">
        <input type="submit" , value="Войти">
    </form>

    <form action="register.jsp">
        <input type="submit" value="Зарегистрироваться">
    </form>
    <br>
${wrongData}
</div>

</body>

</head>
</html>