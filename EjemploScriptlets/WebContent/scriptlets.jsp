<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scriptlets</title>
</head>
<body>
	<h1>Scriptlets</h1>
	<!-- Scriptlets paara enviar infomacion al navegador -->
	<%
		out.print("Saludos desde un scriptlets");
	%>
	<br>
	
	<!-- Scriptlets para accceder alos objetos implicitos -->
	<%
		String nombreAplicacion = request.getContextPath();
	%>
	<!-- Expresion para imprimir la variable declarada en el scriptlets -->
	El nombre de la aplicacion es: <%= nombreAplicacion %>
	<br>
	
	<!-- Scriptlet para agregar codigo condicionado -->
	<%
		if( session != null && session.isNew()){
	%>
	La session SI es nueva!!
	<%
		}else if( session != null ){
	%>
	La sesion NO es nueva!!
	<% } %>
	
</body>
</html>