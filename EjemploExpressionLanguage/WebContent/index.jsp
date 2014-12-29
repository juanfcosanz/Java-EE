<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo Expression Language</title>
</head>
<body>
	<h1>Expression Languaje (EL)</h1>
	<br />
	<a href="variableImplicitas.jsp?usuario=juan">Objetos implicitos
		con EL</a>
	<br />
	<br/>
	<!-- Accedemos al JSp que accede al JavaBean -->
	Formulario HTML:
	<br/>
	<form action="accesoJavaBeans.jsp" name="form1">
	Base: <input type="text" name="base">
	<br/>
	Altura: <input type="text" name="altura">
	<br/>
	<input type="submit" value="Enviar">
	</form>
</body>
</html>