<html>
<head>
    <title>galaxy</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
    <style>
        TABLE {
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
            width: 400px; /* Ширина таблицы */
            margin-top: 25px;
            margin-right: 100px;
        }

        THEAD, TD {
            border: 2px solid black; /* Параметры рамки */
            text-align: center; /* Выравнивание по центру */
            padding: 5px; /* Поля вокруг текста */
        }

        THEAD {
            background: #b0e0e6; /* Цвет фона ячейки */
            height: 50px; /* Высота ячеек */
            vertical-align: bottom; /* Выравнивание по нижнему краю */
            padding: 0; /* Убираем поля вокруг текста */
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

        .styl {
            display: flex;
            justify-content: space-between;
        }

        .name {
            margin-top: 20px;
            margin-right: 70px;
        }

        .p {
            margin-right: 320px;
            margin-top: 20px;
        }
    </style>

</head>
<body>
<div class="styl">
    <div>
        <h2>Input value Orbit</h2>
        <p>
            <label for="Weight"> Weight </label>
            <input class="in" style="width: 200px;" id="weight" type="number" placeholder="min : 1" required/>
        </p>
        <p>
            <label for="Radius"> Radius</label>
            <input style="width: 200px;" id="radius" type="number" placeholder="min : 1" required/></p>
        <p>
            <label for="Height"> Height </label>
            <input style="width: 200px;" id="height" type="number" placeholder="min : 1" required/></p>
        <p>

            <label for="Acceleration"> Acceleration</label>
            <input style="width: 200px;" id="acceleration" type="number" placeholder="value may be negative or positive"
                   required/></p>
        <p>
            <label for="Velocity"> Velocity</label>
            <input style="width: 200px;" id="velocity" type="number" placeholder="value may be less 1"
                   required/>
        </p>

        <h2>Input value Star</h2>
        <p><label for="Weight"> Weight Star</label>
            <input id="star_weight" type="number" required/>
        </p>
        <p>
            <label for="Radius"> Radius Star</label>
            <input id="star_radius" type="number" required/>
        </p>

        <div class="styl">
            <div>
                <p>
                    <input class="button4" type="button" onclick="insertRow('table');" value="addOrbit">
                </p>
                <p>
                <form method="post" action="/upload">
                    <button class="button4" type="submit" value="upload">GetFromDB</button>
                </form>
                </p>
                <p>
                    <button class="button4" id="start" value="start">start</button>
                </p>
            </div>
        </div>
    </div>

    <div>
        <h2 class="name">List Orbit</h2>
        <table id="table" class="p">
            <thead>
            <tr>
                <td>delete</td>
                <td>id</td>
                <td>weight</td>
                <td>radius</td>
                <td>height</td>
                <td>acceleration</td>
                <td>velocity</td>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script>
    var button;

    function insertRow(id) {
        if (document.getElementById("weight").value.length == 0 ||
            document.getElementById("radius").value.length == 0 ||
            document.getElementById("height").value.length == 0 ||
            document.getElementById("acceleration").value.length == 0 ||
            document.getElementById("velocity").value.length == 0
        ) {
            alert("enter numbers in all fields")
        } else if (document.getElementById("weight").value < 1 ||
            document.getElementById("radius").value < 1 ||
            document.getElementById("height").value < 1) {
            alert("enter numbers greater than 1")
        } else {
            var tbody = document.getElementById(id);
            var row = document.createElement("tr");
            var cellCounter = document.getElementById("table").rows.length;

            button = document.createElement("input");
            button.type = 'button';
            button.value = 'Delete';
            button.className = 'deleteDep';
            button.onclick = 'deleteRow()';

            var tdNum = document.createElement("td");
            tdNum.setAttribute('id', 'td1_id');
            tdNum.className = 'td_num';
            tdNum.appendChild(document.createTextNode(cellCounter));

            var tdButton = document.createElement("td");
            tdButton.appendChild(button);

            var tdWeight = document.createElement("td");
            tdWeight.appendChild(document.createTextNode(document.getElementById("weight").value));

            var tdRadius = document.createElement("td");
            tdRadius.appendChild(document.createTextNode(document.getElementById("radius").value));

            var tdHeight = document.createElement("td");
            tdHeight.appendChild(document.createTextNode(document.getElementById("height").value));

            var tdAcceleration = document.createElement("td");
            tdAcceleration.appendChild(document.createTextNode(document.getElementById("acceleration").value));

            var tdVelocity = document.createElement("td");
            tdVelocity.appendChild(document.createTextNode(document.getElementById("velocity").value));
            row.appendChild(tdButton);
            row.appendChild(tdNum);
            row.appendChild(tdWeight);
            row.appendChild(tdRadius);
            row.appendChild(tdHeight);
            row.appendChild(tdAcceleration);
            row.appendChild(tdVelocity);
            tbody.appendChild(row);
            document.getElementById("weight").value = "";
            document.getElementById("radius").value = "";
            document.getElementById("height").value = "";
            document.getElementById("acceleration").value = "";
            document.getElementById("velocity").value = "";
            return false;
        }
    }

    $('body').on('click', 'input.deleteDep', function () {
        $(this).parents('tr').remove();
    });

    var orbits = [];
    var data = {};

    $("#start").click(function () {
        var row = document.getElementById('table').rows;
        for (i = 1; i < row.length; i++) {
            var orbit = {
                "planet": {
                    "weight": row[i].cells[2].innerHTML,
                    "radius": row[i].cells[3].innerHTML,
                    "velocity": row[i].cells[6].innerHTML
                },
                "height": row[i].cells[4].innerHTML,
                "acceleration": row[i].cells[5].innerHTML
            };
            orbits.push(orbit);
        }
        var galaxy = {
            "massiveAstronomicalObject": {
                "weight": document.getElementById('star_weight').value,
                "radius": document.getElementById('star_radius').value
            },
            "orbits": orbits
        };
        data = JSON.stringify(galaxy);

        if (document.getElementById("star_weight").value.length == 0 ||
            document.getElementById("star_radius").value.length == 0) {
            alert("input parametr star");
        } else if (document.getElementById("table").rows.length == 1) {
            alert("table empty, input orbit and click button add");
        } else {
            $.ajax({
                url: "http://localhost:9090/galaxy",
                type: "POST",
                data: data,
                contentType: "application/json; charset=utf-8",
                success: function (response) {
                    window.location.replace("/result");
                }
            })
        }
    });
</script>
</body>
</html>

