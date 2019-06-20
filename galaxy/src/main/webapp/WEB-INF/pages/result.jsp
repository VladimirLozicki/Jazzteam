<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>

<h2>Orbit</h2>
<form:form >
    <table>
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

</form:form>


<div name="condition" > Your system : ${result}</div>
<div name="speed"> speed satellite : ${result1}</div>
<div name="way"> way satellite : ${result2}</div>

</body>
</html>