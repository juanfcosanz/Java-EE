<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expresiones</title>
</head>
<body>
	<h1>JSP de expresiones</h1>
	<br>
	Concatenacion: <%= "Saludos" + "JSP" %>
	<br>
	Operacion Matematica: <%= 2 * 3 / 2 %>
	<br>
	<!-- Llamada a una funcion -->
	SessionID: <%= session.getId() %>
	<br>
	<br>
	<a href="index.jsp">Regresar al inicio</a>

</body>
</html>