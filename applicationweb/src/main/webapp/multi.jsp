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
            width: 80px;
            height: 30px;
            background-color: yellow;
        }
        .input{
            width: 200px;
            height: 30px;
            color: darkturquoise;
        }
    </style>
</head>
<body>
<form action="numberservlet" method="post" align="center">
    <input type="number" name="number" placeholder="input number" class="input">

   <div>
       <textarea class="input"> ${KEY} </textarea>
   </div>
    <input type="submit" value="Calculation" class="button">
</form>
</form>
</body>
</html>
