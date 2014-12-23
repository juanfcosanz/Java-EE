<%--Agregamos un declaracion --%>
<%!//Declaramos una variable con su metod get
	private String usuario = "Juan";

	public String getUsuario() {
		return this.usuario;
	}

	//Declaramos un contador de visitas
	private int contadorVisitas = 1;
%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Uso de Declaraciones</title>
</head>
<body>
	<h1>Declaraciones</h1>
	Usuario por medio del atributo: <%= this.usuario %>
	<br/>
	Usuario por medio del metodo: <%= this.getUsuario() %>
	<br/>
	
	Contador de Visitas: <%= this.contadorVisitas++ %>
</body>
</html>