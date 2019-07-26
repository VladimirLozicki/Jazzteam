<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
    <title>Title</title>
    <style>
        TABLE {
            width: 400px;
            border-collapse: collapse;
        }

        TD, TH {
            padding: 3px;
            border: 1px solid black;
            width: 40px;
            height: 70px;
        }

        TH {
            background: #b0e0e6;
        }
    </style>
</head>
<body>


<table id="table" class="table-view">
    <h3> List orbit in the galaxy</h3>
    <thead>
    <tr>
        <th>weight</th>
        <th>radius</th>
        <th>height</th>
        <th>acceleration</th>
        <th>velocity</th>
        <th>newVelocity</th>
        <th>condition</th>
        <th>firstVelocity</th>
        <th>time</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orbits}" var="item">
        <tr>
            <td>${item.planet.weight}</td>
            <td>${item.planet.radius}</td>
            <td>${item.height}</td>
            <td>${item.acceleration}</td>
            <td>${item.planet.velocity}</td>
            <td>${item.newVelocity}</td>
            <td>${item.condition}</td>
            <td>${item.firstVelocity}</td>
            <td>${time}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h3> Information about center galaxy</h3>
<div>Star_weight ${weight} </div>
<div>Star_radius ${radius} </div>

<form method="get" action="/result">
    <button class="arrow-button" id="result" value="result">result</button>
</form>

<form method="post" action="/save">
    <button class="arrow-button" id="save" value="save">save</button>
</form>

</body>
</html>
