<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Planet</title>
</head>
<body>

<h2>Create parameter system </h2>
<form:form method="post" action="addOrbit">
  <table>
    <tr>
      <td><form:label path="height">radius</form:label></td>
      <td><form:input path="height" /></td>
    </tr>
    <tr>
      <td><form:label path="velocity">velocity</form:label></td>
      <td><form:input path="velocity" /></td>
    </tr>
  </table>
  <input type="submit" value="Submit"/>
</form:form>
</body>
</html>