<%--
  Created by IntelliJ IDEA.
  User: denisgrebenuk
  Date: 20/10/2018
  Time: 02:11
  To change this template use File | Settings | File Templates.
--%>

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
                <td><form action="/changeUser" method="get">
                <td> <input type="hidden" name="idChange" value="${user.id}"/> </td>
                <td> <input type="hidden" name="nameChange" value="${user.name}"/> </td>
                <td> <input type="hidden" name="ageChange" value="${user.age}"/> </td>
                <td> <input type = "submit" value = "Change User"> </td>
                </form>
                </td>
                <td><form action="/Remove-User" method="post">
                <td> <input type="hidden" name="id" value="${user.id}"/> </td>
                <td> <input type = "submit" value = "Remove User"> </td>
                </form>
                </td>
                <%--<td> <a href = "changeUser.jsp"> Change User</a></td>--%>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <form action="AddUser.jsp">
        <input type="submit" value="Add User">
    </form>
    <%--<a href = "AddUser.jsp"> Add User</a>--%>

</div>

</body>

</head>
</html>
