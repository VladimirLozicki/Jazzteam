<%--
  Created by IntelliJ IDEA.
  User: vladimirlozickiy
  Date: 2019-06-27
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty orbits}">
      <table>
        <tr style="margin-right: 10px">weight</tr>
        <tr style="width: 80px">radius</tr>
        <tr style="width: 80px">name</tr>
        <tr style="width: 80px">height</tr>
        <tr style="width: 80px">acceleration</tr>
        <tr style="width: 80px">edit</tr>
        <tr style="width: 80px">delete</tr>
        <c:forEach items="${orbits}" var="orbit">
            <tr>
                <td>${radius}</td>
                <td>${weight}</td>
                <td>${name}</td>
                <td>${acceleration}</td>
                <td>${height}</td>
            </tr>
        </c:forEach>
        <tr></tr>
    </table>
</c:if>
</body>
</html>
