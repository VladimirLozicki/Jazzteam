<%--
  Created by IntelliJ IDEA.
  User: vladimirlozickiy
  Date: 2019-04-25
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
    <style>
        .button {
            width: 70px;
            height: 30px;
            border-color: indigo;
            background-color:hotpink;
            color: darkblue;
        }
    </style>
</head>
 <h1 align="center">Welcome on page with Task</h1>
    <form action="multi.jsp">
        <input type="submit" value="Multiply" class="button">
    </form>
    <form action="list.jsp">
        <input type="submit" value="List" class="button">
    </form>
</html>
