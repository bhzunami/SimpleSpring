<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Simple Spring Hibernate Maven </title>
</head>
<body>

	<h2>Person Manager</h2>

	<form:form method="post" action="add.html" commandName="person">

		<table>
			<tr>
				<td><form:label path="firstname">
						<spring:message code="label.firstName" />
					</form:label></td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">
						<spring:message code="label.lastName" />
					</form:label></td>
				<td><form:input path="lastname" /></td>
			</tr>
			
			<tr>
				<td><form:label path="address.address">
						<spring:message code="label.address" />
					</form:label></td>
				<td><form:input path="address.address" /></td>
			</tr>
			
			<tr>
				<td><form:label path="age">
						<spring:message code="label.age" />
					</form:label></td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.addPerson"/>" /></td>
			</tr>
		</table>
	</form:form>


	<h3>Persons</h3>
	<c:if test="${!empty persons}">
		<table class="data">
			<tr>
				<th>Name</th>
				<th>age</th>
				<th>address</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${persons}" var="person">
				<tr>
					<td>${person.lastname},${person.firstname}</td>
					<td>${person.age}</td>
					<td>${person.address.address}</td>
					<td><a href="delete/${person.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>