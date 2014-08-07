<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Procesa Formulario</title>
</head>
<body>
	<h1>Resulatdo de Procesar Formulario</h1>
	Usuario: <%= request.getParameter("usuario") %>
	<br>
	Password: <%= request.getParameter("password") %>
	<br>
	<br>
	<a href="index.jsp">Regrasar al inicio</a>

</body>
</html>