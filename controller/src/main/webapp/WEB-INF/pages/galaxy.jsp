<html>
<head>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>

    <style>
        TABLE {
            width: 400px;
            border-collapse: collapse;
        }
        TD, TH {
            padding: 3px;
            border: 1px solid black;
        }
        TH {
            background: #b0e0e6;
        }

    </style>
</head>
<body>
<form>
    <p>
        <label for="Weight"> Weight </label>
        <input id="weight" type="number" placeholder="min : 1"  required/>
    </p>
    <p>
        <label for="Radius"> Radius</label>
        <input id="radius" type="number"  placeholder="min : 1"  required/></p>
    <p>
        <label for="Height"> Height </label>
        <input id="height"  type="number"  placeholder="min : 1" required/></p>
    <p>
        <label for="Acceleration"> Acceleration</label>
        <input id="acceleration" type="number"  required/></p>
</form>

<button type="button" onclick="insertRow('table'); ">Add</button>

<table id="table" >
    <tr>
        <td>button</td>
        <td>id</td>
        <td>weight</td>
        <td>radius</td>
        <td>height</td>
        <td>acceleration</td>
    </tr>
</table>

<form >  <%--method="post" action="galaxy">--%>
    <p><label for="Weight"> Weight Star</label>
        <input id="star_weight" type="number" required/>
    </p>
    <p>
        <label for="Radius"> Radius Star</label>
        <input id="star_radius" type="number" required/>
    </p>
    <input type="hidden" id="hidden">
</form>
<button id="start"> start</button>
<input type="submit" value="upload">

<script>
    var checkbox;
    function insertRow(id) {
        if (document.getElementById("weight").value.length == 0 ||
            document.getElementById("radius").value.length == 0 ||
            document.getElementById("height").value.length == 0 ||
            document.getElementById("acceleration").value.length == 0) {
            alert("enter numbers in all fields greater than 1")
        } else if(document.getElementById("weight").value < 1 ||
            document.getElementById("radius").value < 1 ||
            document.getElementById("height").value <1 ){
        }

        else {
            var tbody = document.getElementById(id),
                row = document.createElement("tr"),
                cellCounter = document.getElementById("table").rows.length;

            checkbox = document.createElement("input");
            checkbox.type = 'button';
            checkbox.value = 'Delete';
            checkbox.className = 'deleteDep';
            checkbox.onclick = 'deleteRow()';

            var tdNum = document.createElement("td");
            tdNum.setAttribute('id', 'td1_id');
            tdNum.className = 'td_num';
            tdNum.appendChild(document.createTextNode(cellCounter));

            var tdDone = document.createElement("td");
            tdDone.appendChild(checkbox);

            var tdItem = document.createElement("td");
            tdItem.appendChild(document.createTextNode(document.getElementById("weight").value));

            var tdQuant = document.createElement("td");
            tdQuant.appendChild(document.createTextNode(document.getElementById("radius").value));

            var tdPrice = document.createElement("td");
            tdPrice.appendChild(document.createTextNode(document.getElementById("height").value));

            var tdAcceleration = document.createElement("td");
            tdAcceleration.appendChild(document.createTextNode(document.getElementById("acceleration").value));
            row.appendChild(tdDone);
            row.appendChild(tdNum);
            row.appendChild(tdItem);
            row.appendChild(tdQuant);
            row.appendChild(tdPrice);
            row.appendChild(tdAcceleration);

            tbody.appendChild(row);
            document.getElementById("weight").value = "";
            document.getElementById("radius").value = "";
            document.getElementById("height").value = "";
            document.getElementById("acceleration").value = "";
            return false;
        }
    }

    $('body').on('click', 'input.deleteDep', function() {
        $(this).parents('tr').remove();
    });


    var galaxy;
    var orbits = [];
    var data={};
    function check() {
        var row = document.getElementById('table').rows;
        for (i = 1; i < row.length; i++) {
            var orbit = {
                "weight": row[i].cells[1].innerHTML,
                "radius": row[i].cells[2].innerHTML,
                "height": row[i].cells[3].innerHTML,
                "acceleration": row[i].cells[4].innerHTML
            };
            orbits.push(orbit);
        }
        galaxy = {
            "orbits": orbits,
            "star_weight": document.getElementById('star_weight').value,
            "star_radius": document.getElementById('star_radius').value
        };
       data=JSON.stringify(galaxy);
    }

    $("#start").click(function () {
        check();
        $.ajax({
            url: "http://localhost:9090/galaxy",
            type: "POST",
            data: data,
            //dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function (response) {
                // $('#result').html(response.star_weight);
            }
        })
    });

</script>
</body>
</html>

