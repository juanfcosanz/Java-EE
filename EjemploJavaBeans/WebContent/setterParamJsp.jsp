<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP que modifica un JB por parametros</title>
</head>
<body>
	<h1>Parametros JB</h1>
	<!-- Declaramos el JB a utiliza -->
	<jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
	
	Modificacion de los atributos:
	<br/>
	<br/>
	<jsp:setProperty property="base" name="rectangulo" param="baseParam"/>
	Nuevo Valor base : <%= request.getParameter("baseParam") %>
	<br/>
	<jsp:setProperty property="altura" name="rectangulo" param="alturaParam"/>
	Nuevo Valor altura : <%= request.getParameter("alturaParam") %>
	<br/>
	<br/>
	<a href="index.jsp">Regresar</a>
</body>
</html>