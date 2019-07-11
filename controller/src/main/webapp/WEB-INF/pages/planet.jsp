<html>
<head>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
    <style>
        TABLE {
            width: 400px; /* Ширина таблицы */
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        TD, TH {
            padding: 3px; /* Поля вокруг содержимого таблицы */
            border: 1px solid black; /* Параметры рамки */
        }
        TH {
            background: #b0e0e6; /* Цвет фона */
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
        <input id="acceleration" type="number"  placeholder="min : 1" required/></p>


</form>
<button class="input_button" type="button" onclick="insertRow('table'); value=''">Add</button>
<input type="button" value="print" onclick="submit()" id="print"></button>
<table id="table" >
    <tr>
        <td>button</td>
        <td>id</td>
        <td>weight</td>
        <td>radius</td>
        <td>height</td>
        <td>acceleration</td>
    </tr>
    <tbody>
    </tbody>
</table>
<p>
    <label for="Weight"> Weight Star</label>
    <input id="star_weight" type="number"   required/>
</p>
<p>
    <label for="Radius"> Radius Star</label>
    <input id="star_radius" type="number" required/>
</p>
<input type="submit" value="start">
<input type="submit" value="upload">

    <script>

        $('body').on('click', 'input.deleteDep', function() {
            $(this).parents('tr').remove();
        });


        var checkbox;
        function insertRow(id) {
            if(document.getElementById("weight").value.length==0 ||
                document.getElementById("radius").value.length==0 ||
                document.getElementById("height").value.length==0 ||
                document.getElementById("acceleration").value.length==0){
                alert("enter numbers in all fields greater than 1")
            }
            else{
                var inputButton = document.getElementsByClassName('input_button')[0];
                if (inputButton.innerText == "Update") {
                    updateRow(inputButton);
                    return false;
                }

                var tbody = document.getElementById(id),
                    row = document.createElement("tr"),
                    cellCounter = document.getElementById("table").rows.length;

                checkbox = document.createElement("input");
                checkbox.type = 'button';
                checkbox.value='Delete';
                checkbox.className = 'deleteDep';
                checkbox.onclick='deleteRow()';

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
                document.getElementById("weight").value=""
                document.getElementById("radius").value=""
                document.getElementById("height").value=""
                document.getElementById("acceleration").value=""
                return false;
            }
        }


    var data;
    var orbits = {};
    var i=1;
    function submit(){
        var row = document.getElementById ('table').rows.length;
      //  for(i; i<row.length; i++){
            orbits = {
                "orbit": {
                    "id":  document.getElementById('table').rows[1].cells[1].innerHTML,
                    "weight":  document.getElementById('table').rows[1].cells[2].innerHTML,
                    "radius":  document.getElementById('table').rows[1].cells[3].innerHTML,
                    "height":  document.getElementById('table').rows[1].cells[4].innerHTML,
                    "acceleration":  document.getElementById('table').rows[1].cells[5].innerHTML,
                    "star_weight":  document.getElementById('star_weight').value,
                    "star_radius":  document.getElementById('star_radius').value
                }
            };
            data = JSON.stringify(orbits);
    }

    $(function () {
        $("#print").click(function () {
            $.ajax({
                url: "http://localhost:9090/planet",
                type: "POST",
                data: {data:data},
                dataType: "json",
                success: function(response){
                    alert(response);
                }
            })
        })
    });

</script>
</body>
</html>