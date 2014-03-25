<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title><spring:message code="label.title" /> </title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
    	body { background-color: #eee; font: helvetica; }
    	#container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; }
    	.green { font-weight: bold; color: green; }
    	.message { margin-bottom: 10px; }
    	label {width:70px; display:inline-block;}
    	input { display:inline-block; margin-right: 10px; }
    	form {line-height: 160%; }
    	.hide { display: none; }
    	.error { color: red; font-size: 0.9em; font-weight: bold; }
    </style>
  </head>
<body>

	<h2>Person Manager</h2>

	<form:form method="post" action="save" modelAttribute="person">
		<table>
			<tr>
				<td><form:label path="firstname"><spring:message code="label.firstname" /></form:label></td>
				<td><form:input path="firstname" placeholder="Hans" />
				<form:errors path="firstname" cssclass="error"></form:errors></td>
				
				<td><form:label path="lastname"><spring:message code="label.lastname" /></form:label></td>
				<td><form:input path="lastname" placeholder="Muster" />
				<form:errors path="lastname" cssclass="error"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="age" ><spring:message code="label.age" /></form:label></td>
				<td><form:input path="age" />
				
				</td>
			</tr>
			<tr>
				<td><form:label path="address.address"><spring:message code="label.address.streetname" /></form:label></td>
				<td><form:input path="address.address" /></td>
			</tr>
			<tr>
				<td><form:label path="address.city"><spring:message code="label.address.city" /></form:label></td>
				<td><form:input path="address.city" /></td>
			</tr>
			<tr>
				<td><form:label path="address.country"><spring:message code="label.address.country" /></form:label></td>
				<td><form:input path="address.country" /></td>
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
				<th><spring:message code="label.fullname" /></th>
				<th>age</th>
				<th>address</th>
				<th>city</th>
				<th>country</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${persons}" var="person">
				<tr>
					<td>${person.fullName}</td>
					<td>${person.age}</td>
					<td>${person.address.address}</td>
					<td>${person.address.city}</td>
					<td>${person.address.country}</td>
					<td><a href="delete/${person.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>