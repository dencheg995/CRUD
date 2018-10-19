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
        <c:forEach items="${userList}" var = "users"  >
            <tr>
                <td> ${users.id} </td>
                <td><c:out value="${users.name}" /></td>
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