<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC - Contactos</title>
<style type="text/css">
body {
	font-family: sans-serif;
}

.data,.data td {
	border-collapse: collapse;
	width: 80%;
	border: 1px solid #aaa;
	margin: 2px;
	padding: 2px;
}

.data th {
	font-weight: bold;
	background-color: #5C82FF;
	color: white;
}
</style>
</head>
<body>
	<h2>
		<spring:message code="label.title" />
	</h2>
	<form:form method="post" action="add.html" commandName="contacto">
		<table>
			<tr>
				<td><form:label path="nombre">
						<spring:message code="label.firstname" />
					</form:label></td>
				<td><form:input path="nombre" /></td>
			</tr>
			<tr>
				<td><form:label path="apellido">
						<spring:message code="label.lastname" />
					</form:label></td>
				<td><form:input path="apellido" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message code="label.email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="telefono">
						<spring:message code="label.telephone" />
					</form:label></td>
				<td><form:input path="telefono" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.addcontact"/>" /></td>
			</tr>
		</table>
	</form:form>

	<h3>Contactos</h3>
	<c:if test="${!empty contactoList}">
		<table class="data">
			<tr>
				<th><spring:message code="label.firstname" /></th>
				<th><spring:message code="label.email" /></th>
				<th><spring:message code="label.telephone" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${contactoList}" var="contacto">
				<tr>
					<td>${contacto.apellido},${contacto.nombre}</td>
					<td>${contacto.email}</td>
					<td>${contacto.telefono}</td>
					<td><a href="delete/${contacto.idContacto}">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>