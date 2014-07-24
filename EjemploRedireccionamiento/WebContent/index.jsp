<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejemplo Redireccionamiento</title>
</head>
<body>
	<h1>Redireccionando</h1>
	<br />
	<a href="/EjemploRedireccionamiento/RedireccionamientoServlet">Link
		al Servlet de Redireccionamiento</a>
	<br />
	<a href="/EjemploRedireccionamiento/RecursoNoExistente">Link a un
		Recurso No Existente</a>
	<br />

	<fieldset>
		<legend>Fomulario de Autorización</legend>
		<form action="/EjemploRedireccionamiento/FormularioServlet" name="form1" method="post">
			Usuario:<input type="text" name="usuario" /> <br /> 
			Password:<input type="password" name="password" /> <br /> <input type="submit"
				value="Enviar">
		</form>
	</fieldset>
</body>
</html>