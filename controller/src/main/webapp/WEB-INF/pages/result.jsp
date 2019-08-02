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

        .button4 {
            position: relative;
            display: inline-block;
            font-family: Arial, Helvetica, FreeSans, "Liberation Sans", "Nimbus Sans L", sans-serif;
            font-size: 1.5em;
            font-weight: 300;
            color: rgb(245, 245, 245);
            text-shadow: 0 -1px rgba(0, 0, 0, .1);
            text-decoration: none;
            user-select: none;
            padding: .3em 1em;
            outline: none;
            border: none;
            border-radius: 3px;
            background: #0c9c0d linear-gradient(#82d18d, #0c9c0d);
            box-shadow: inset #72de26 0 -1px 1px, inset 0 1px 1px #98ff98, #3caa3c 0 0 0 1px, rgba(0, 0, 0, .3) 0 2px 5px;
            -webkit-animation: pulsate 1.2s linear infinite;
            animation: pulsate 1.2s linear infinite;
        }

        .button4:hover {
            -webkit-animation-play-state: paused;
            animation-play-state: paused;
            cursor: pointer;
        }

        .button4:active {
            top: 1px;
            color: #fff;
            text-shadow: 0 -1px rgba(0, 0, 0, .3), 0 0 5px #ffd, 0 0 8px #fff;
            box-shadow: 0 -1px 3px rgba(0, 0, 0, .3), 0 1px 1px #fff, inset 0 1px 2px rgba(0, 0, 0, .8), inset 0 -1px 0 rgba(0, 0, 0, .05);
        }

        .styl {
            display: flex;
            justify-content: space-between;
        }

        .p {
            margin-right: 500px;
        }

    </style>
</head>
<body>
<div>
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
</div>

<div>
    <h2> Center galaxy</h2>
    <div id="star_weight"><h4>Star_weight ${weight} </h4></div>
    <div id="star_radius"><h4>Star_radius ${radius} </h4></div>
</div>

<div>
    <div>
        <form method="get" action="/result">
            <button class="button4" id="result" value="result">result</button>
        </form>

    </div>
    <div>
        <form method="post" action="/back">
            <button class="button4" id="back" value="back">back</button>
        </form>
        <form method="post" action="/new">
            <button class="button4" id="save" value="save">save</button>
        </form>
    </div>
</div>
<script>
    var data = {};
    $("#result").click(function () {
        var orbits = [];
        var row = document.getElementById('table').rows;
        for (var i = 1; i < row.length; i++) {
            var orbit = {
                "planet": {
                    "weight": row[i].cells[0].innerHTML,
                    "radius": row[i].cells[1].innerHTML,
                    "velocity": row[i].cells[4].innerHTML
                },
                "height": row[i].cells[2].innerHTML,
                "acceleration": row[i].cells[3].innerHTML,
                "newVelocity": row[i].cells[5].innerHTML,
                "condition": row[i].cells[6].innerHTML,
                "firstVelocity": row[i].cells[7].innerHTML
            };
            orbits.push(orbit);
        }

        var galaxy = {
            "massiveAstronomicalObject": {
                "weight": document.getElementById('star_weight').value,
                "radius": document.getElementById('star_radius').value
            },
            "orbits": orbits,
            "time": row[1].cells[8].innerHTML
        };
        data = JSON.stringify(galaxy);
        $.ajax({
            url: "http://localhost:9090/result",
            type: "POST",
            data: data,
            contentType: "application/json; charset=utf-8",
            success: function (response) {
            }
        });
    });
</script>
</body>
</html>
