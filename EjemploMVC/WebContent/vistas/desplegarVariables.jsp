<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Despliegue de VAriables</title>
</head>
<body>
	<h1>Desplegando Variables</h1>
	<br/>
	Variables en alcance request:
	${mensaje}
	<br/>
	<br/>
	Variables en alcance session:
	<br/>
	Rectangulo: 
	Base: ${rectangulo.base},
	Altura: ${rectangulo.altura},
	Area: ${rectangulo.area}
	
	<br/>
	<br/>
	<a href="/EjemploMVC/index.jsp">Regresar</a>
</body>
</html>