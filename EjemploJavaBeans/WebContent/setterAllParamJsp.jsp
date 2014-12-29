<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSp que modifica un JB por parametros</title>
</head>
<body>
	<h1>JSP por parametros</h1>
	<!-- Declaramos el JB a utilizar -->
	<jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
	
	<!-- modificamos todas las propiedade cuyo parametro 
	coincida con el nombre de la propiedad -->
	<jsp:setProperty property="*" name="rectangulo"/>
	
	Se modificaron todos los atributos:
	<br/>
	<br/>
	Nuevo valor base: <%=request.getParameter("base") %>
	<br/>
	Nuevo valor altura: <%= request.getParameter("altura") %>
	<br/>
	<a href="index.jsp">Regresar</a> 

</body>
</html>