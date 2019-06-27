<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Planet</title>
</head>
<body>

<h2>Create system </h2>
<form:form method="post" action="addOrbit">
    <table>
        <tr>
            <td><form:label path="planet.weight">Planet weight</form:label></td>
            <td><form:input path="planet.weight"/></td>
       </tr>
        <tr>
            <td><form:label path="planet.radius">Planet radius</form:label></td>
            <td><form:input path="planet.radius"/></td>
        </tr>
        <tr>
            <td><form:label path="planet.name">Planet name</form:label></td>
            <td><form:input path="planet.name"/></td>
        </tr>
        <tr>
            <td><form:label path="height">height orbit</form:label></td>
            <td><form:input path="height"/></td>
        </tr>
        <tr>
            <td><form:label path="acceleration">acceleration</form:label></td>
            <td><form:input path="acceleration"/></td>
        </tr>
    </table>
    <input type="submit" value="add"/>

</form:form>


</body>
</html>