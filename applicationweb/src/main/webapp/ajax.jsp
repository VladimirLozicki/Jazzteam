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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script src="js/script.js" type="text/javascript"></script>

    <style>
        .input {
            background-color: cornflowerblue;
            color: darkblue;
        }
    </style>
</head>
<body>
<h1 align="center"><span style="color: sandybrown"> Add item</span></h1>
<form align="center">
    <input type="number"  name="value" value="number" id="number">
    <input type="submit" value="addFront"  class="input" id="front">
    <input type="submit" value="addBack" name="action" class="input"  id="back">
</form>

<div align="center" id="answer" > List: ${VALUE}  </div>

</body>
</html>
