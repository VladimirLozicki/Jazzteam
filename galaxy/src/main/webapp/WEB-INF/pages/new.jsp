<%--
  Created by IntelliJ IDEA.
  User: vladimirlozickiy
  Date: 2019-06-18
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>

<form:form>
    <table>
        <tr>
            <td>weight</td>
            <td>${weight}</td>
        </tr>
        <tr>
            <td>weight</td>
            <td>${weight}</td>
        </tr>
        <tr>
            <td>radius</td>
            <td>${radius}</td>
        </tr>
        <tr>
            <td>name</td>
            <td>${planet_name}</td>
        </tr>
        <tr>
            <td>height</td>
            <td>${height}</td>
        </tr>
        <tr>
            <td>velocity</td>
            <td>${velocity}</td>
        </tr>
        <tr>
            <td>time</td>
            <td>${time}</td>
        </tr>
        <tr>
            <td>name</td>
            <td>${satellite_name}</td>
        </tr>
        <tr>
            <td>acceleration</td>
            <td>${acceleration}</td>
        </tr>
    </table>
    <div name="condition" > Your system : ${result}</div>
    <div name="speed"> speed satellite : ${result1}</div>
    <div name="way"> way satellite : ${result2}</div>
</form:form>

</body>
</html>