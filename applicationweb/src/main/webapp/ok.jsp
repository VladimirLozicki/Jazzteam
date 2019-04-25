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
    <title>Title</title>
    <style>
        .button {
            width: 40px;
            height: 30px;
            border-color: indigo;
            background-color: lawngreen;
            color: darkblue;
        }
    </style>
</head>
<div align="center">
    <form action="multi.jsp">
        <input type="submit" value="Task1" class="button">
    </form>
    <form action="list.jsp">
        <input type="submit" value="Task2" class="button">
    </form>
</div>
</html>
