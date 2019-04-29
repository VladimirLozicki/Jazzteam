<%--
  Created by IntelliJ IDEA.
  User: vladimirlozickiy
  Date: 2019-04-25
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .button {
            width: 50px;
            height: 30px;
            border-color: rebeccapurple;
            background-color: darkturquoise;
            color: darkblue;
        }

        .input {
            background-color: cornflowerblue;
            color: darkblue;
        }
    </style>
</head>
<body>
<h1 align="center" ><span style="color: sandybrown"> Add item</span></h1>
<form action="listservlet" method="post" align="center">
    <input type="number"  name="value">
    <input type="submit" value="addFront" name="action" class="input">
    <input type="submit" value="addBack" name="action" class="input">
</form>
<div align="center"> List:  ${VALUE} </div>
<div align="center"> List:  ${VAL} </div>
</body>
</html>
