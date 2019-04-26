<%--
  Created by IntelliJ IDEA.
  User: vladimirlozickiy
  Date: 2019-04-25
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
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
        .text{
            width: 50px;
            height: 30px;
            border-bottom: lawngreen;
            background-color: blanchedalmond;
            margin-left: 450px;
        }
    </style>
</head>
<body>

<form action="numberservlet" method="post" align="center">
    <input type="number" name="number" class="input">

    <input type="submit" value="Calculation" class="button">
</form>

<textarea  class="text" placeholder="Result" > ${KEY} </textarea>


</form>
</body>
</html>
