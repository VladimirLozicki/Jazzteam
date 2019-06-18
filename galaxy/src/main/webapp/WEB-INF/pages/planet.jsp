<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Planet</title>
</head>
<body>

<h2>Create parameter system </h2>
<form:form method="post" action="addOrbit">
    <table>
        <tr>
            <td><form:label path="planet.weight">weight</form:label></td>
            <td><form:input path="planet.weight"/></td>
       </tr>
        <tr>
            <td><form:label path="planet.radius">radius</form:label></td>
            <td><form:input path="planet.radius"/></td>
        </tr>
        <tr>
            <td><form:label path="planet.name">name</form:label></td>
            <td><form:input path="planet.name"/></td>
        </tr>
        <tr>
            <td><form:label path="height">height</form:label></td>
            <td><form:input path="height"/></td>
        </tr>
        <tr>
            <td><form:label path="satellite.velocity">velocity</form:label></td>
            <td><form:input path="satellite.velocity"/></td>
        </tr>
        <tr>
            <td><form:label path="satellite.name">name</form:label></td>
            <td><form:input path="satellite.name"/></td>
        </tr>

        <tr>
            <td><form:label path="acceleration">acceleration</form:label></td>
            <td><form:input path="acceleration"/></td>
        </tr>
    </table>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>