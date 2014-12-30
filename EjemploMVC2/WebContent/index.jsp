<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo 2 MVC</title>
</head>
<body>
	<h1>MVC 2</h1>
	<!-- Utilizamos una variable de mensaje que se almacena desde 
	el servlet en caso de querer mostrar cierta informacion al usuario -->
	<div style="color: red">${mensaje}</div>

	<br />
	<a href="${pageContext.request.contextPath}/ServletControlador">Link
		al Servlet Controlador </a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables">
	Link al Servlet Controlador  para agregar las variables al scope respectivo</a>
	
	<br/>
	<br/>
	<a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">Link
		al Servlet Controlador pra listar las variables </a>

</body>
</html>