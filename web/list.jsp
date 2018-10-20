<%--
  Created by IntelliJ IDEA.
  User: denisgrebenuk
  Date: 20/10/2018
  Time: 02:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="project.UserDataSet.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>TITLE</title>

<body>
<h1>HELLO!</h1>
<div>
    <table>
        <tbody>
        <tr>
            <th>id</th><th>Name</th><th>age</th>
        </tr>
        <c:forEach var = "user" items="${list}"  >
            <tr>
                <td> ${user.id} </td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.age}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href = "AddUser.jsp"> Add User</a>
    <br>
    <a href = "removeUser.jsp"> Remove User</a>
    <br>
    <a href = "changeUser.jsp"> Change User</a>
</div>

</body>

</head>
</html>
