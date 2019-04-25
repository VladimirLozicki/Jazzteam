<%--
  Created by IntelliJ IDEA.
  User: vladimirlozickiy
  Date: 2019-04-25
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .button {
            width: 70px;
            height: 30px;
            background-color: yellow;
        }

        .input {
            width: 70px;
            height: 30px;
            color: teal;
        }
    </style>
</head>
<body>

<form action="numberservlet" method="post" align="center">
    <input type="number" name="number" class="input">

    <input type="submit" value="вычислить" class="button">
</form>
<div align="center"> ${KEY} </div>
</body>
</html>
