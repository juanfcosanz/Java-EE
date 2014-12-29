<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo JavaBeans</title>
</head>
<body>
	<h1>JavaBeans</h1>
	<!-- JSP para modificar valores -->
	<a href="setterJsp.jsp">Modificar valores del JavaBean</a>
	<br />
	<!-- JSP que lee valores del JB -->
	<a href="getterJsp.jsp">Leer valores del JavaBeans</a>
	<br/>
	<br/>
	<!-- JSP para recuperar parametros de un formulario -->
	<!-- Formulario 1 -->
	<form action="setterParamJsp.jsp" name="form1">
	Base: <input type="text" name="baseParam">
	<br/>
	Altura: <input type="text" name="alturaParam">
	<br/>
	<input type="submit">
	</form>
	
	<br/>
	<br/>
	Formulario 2:
	<form action="setterAllParamJsp.jsp" name="form2">
	Base: <input type="text" name="base">
	<br/>
	Altura: <input type="text" name="altura">
	<br/>
	<br/>
	<input type="submit">
	</form>
	
</body>
</html>