<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acceso al JB</title>
</head>
<body>
	<h1>JavaBeans</h1>
	<jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />

	<!-- Asignamos los valores del formulario al JavaBean -->
	<jsp:setProperty property="*" name="rectangulo" />
	
	<br/>
	Valor base : ${rectangulo.base}
	<br/>
	Valor altura: ${rectangulo.altura}
	<br/>
	Calculo Area: ${rectangulo.area}
</body>
</html>