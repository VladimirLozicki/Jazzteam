<html>
<head>
    <style>
        .button {
            width: 45px;
            height: 20px;
            border-color: brown;
            background-color: lawngreen;
            color: darkblue;
        }

        .input {
            width: 100px;
            height: 20px;
            color: crimson;
            border-color: darkmagenta;
            color: darkblue;
        }
    </style>
</head>
<body>
<form action="servlet" method="get" align="center">
    <div><input type="login" name="login" class="input" value="admin"></div>
    <div><input type="password" name="password" class="input" value="admin"></div>
    <input type="submit" value="Submit" class="button">
    <input type="reset" value="Reset" class="button">
</form>
</body>
</html>
