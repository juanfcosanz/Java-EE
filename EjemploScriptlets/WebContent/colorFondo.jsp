<!-- Scriptlets para procesar el parametro -->
<%
	String fondo = request.getParameter("color");

	if (fondo == null || fondo.trim().equals("")) {
		fondo = "white";
	} else {

	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JS Cambio de color de Fondo</title>
</head>
<body bgcolor="<%= fondo %>">
	<h1>
		Fondo aplicado: <%=fondo%>
	</h1>
	<br>
	<a href="index.jsp">Regresar al inicio</a>
</body>
</html>