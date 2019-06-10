<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Developer</title>
</head>
<body>

<h2>Enter developer information</h2>
<form:form method="post" action="addPlanet">
  <table>
    <tr>
      <td><form:label path="density">density</form:label></td>
      <td><form:input path="density" /></td>
    </tr>
    <tr>
      <td><form:label path="rotationPeriod">rotationPeriod</form:label></td>
      <td><form:input path="rotationPeriod" /></td>
    </tr>
    <tr>
      <td><form:label path="secondCosmicVelocity">secondCosmicVelocity</form:label></td>
      <td><form:input path="secondCosmicVelocity" /></td>
    </tr>
    <tr>
      <td><form:label path="name">name</form:label></td>
      <td><form:input path="name" /></td>
    </tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>