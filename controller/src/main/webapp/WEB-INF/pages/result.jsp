<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
<body >
<table class="table-view">
    <h3> List orbit in the galaxy</h3>
    <thead>
    <tr>
        <th>weight</th>
        <th>radius</th>
        <th>height</th>
        <th>acceleration</th>
        <th>velocity</th>
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
        </tr>
    </c:forEach>
    </tbody>
</table>
<h3> Information about center galaxy</h3>
<div>Star_weight ${weight} </div>
<div>Star_radius ${radius} </div>
<button class="arrow-button" id="result" onclick="reload()" value="GetCurrent">getCurrent</button>
<button class="arrow-button" id="save" value="save">save</button>
<table>
    <h3> Conditions orbits</h3>
    <thead>
    <tr>
        <th>velocity</th>
        <th>way</th>
        <th>condition</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orbits}" var="item">
        <tr>
            <td> ${item.newVelocity}</td>
            <td> ${item.newHeight}</td>
            <td> ${item.condition}</td>
        </tr>
    </c:forEach>
    </tbody>

    <div class="text">Time  ${time}</div>

</table>
</body>
<script>
    function reload() {
        window.location.reload(true);
    }
</script>

</html>
