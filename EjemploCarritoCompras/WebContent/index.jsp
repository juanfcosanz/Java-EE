<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejemplo Carrito Compras</title>
</head>
<body>
	<h1>Carrito de Compras</h1>
	<form action="/EjemploCarritoCompras/CarritoServlet" method="post" name="form1">
		Articulo a agregar: 
		<input type="text" name="articulo">
		<br />
		<input type="submit" value="Comprar">
	</form>
</body>
</html>