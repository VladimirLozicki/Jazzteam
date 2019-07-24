<html>
<head>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
    <style>
        TABLE {
            width: 400px;
            border-collapse: collapse;
        }

        TD, TH {
            width: 30px;
            padding: 3px;
            border: 1px solid black;
        }

        TH {
            background: #b0e0e6;
        }

        button {
            width: 70px;
            height: 20px;
        }
    </style>
</head>
<body>
<form>
    <p>
        <label for="Weight"> Weight </label>
        <input style="width: 200px;" id="weight" type="number" placeholder="min : 1" required/>
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
               required/></p>
</form>

<input class="arrow-button" type="button" onclick="insertRow('table');" value="add">
<table id="table" class="table-view">
    <tr>
        <td>delete</td>
        <td>id</td>
        <td>weight</td>
        <td>radius</td>
        <td>height</td>
        <td>acceleration</td>
        <td>velocity</td>
    </tr>
</table>
<form>
    <p><label for="Weight"> Weight Star</label>
        <input id="star_weight" type="number" required/>
    </p>
    <p>
        <label for="Radius"> Radius Star</label>
        <input id="star_radius" type="number" required/>
    </p>
    <input type="hidden" id="hidden">
</form>

<form method="post" action="/upload">
    <button class="arrow-button" type="submit" value="upload">upload</button>
</form>

<button class="arrow-button" id="start" value="start">start</button>
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
            row = document.createElement("tr");
            cellCounter = document.getElementById("table").rows.length;

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

    var galaxy;
    var orbits = [];
    var data = {};

    $("#start").click(function () {
        var row = document.getElementById('table').rows;
        for (i = 1; i < row.length; i++) {
            var orbit = {
                "planet": {
                    "weight": row[i].cells[2].innerHTML,
                    "radius": row[i].cells[3].innerHTML,
                    "velocity": row[i].cells[6].innerHTML,
                },
                "height": row[i].cells[4].innerHTML,
                "acceleration": row[i].cells[5].innerHTML,
            };
            orbits.push(orbit);
        }
        galaxy = {
            "massiveAstronomicalObject": {
                "weight": document.getElementById('star_weight').value,
                "radius": document.getElementById('star_radius').value
            },
            "orbit": orbits
        };
        data = JSON.stringify(galaxy);

        if (document.getElementById("star_weight").value.length == 0 ||
            document.getElementById("star_radius").value.length == 0) {
            alert("input parametr star");
        } else if (document.getElementById("table").rows.length == 1) {
            alert("table empty");
        }
        else {
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

