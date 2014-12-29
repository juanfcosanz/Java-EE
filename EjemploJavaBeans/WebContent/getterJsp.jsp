<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP que lee valores del JB</title>
</head>
<body>
	<h1>JSP que lee valores</h1>
	<!-- Declaramos el JB a utilizar
	si ya existe un bean en la session llamado "rectangulo", 
	regresa el mismo objeto	y no crea uno nuevo
	Si el bean fuera de otro tipo, la informacion procesada por el jsp setterJPS
	se perderia al regresar al jsp principal y este jsp no pódria recupara la informacion
	--> 
	
	<!--si este objeto ya exite, regresa la instancia 
	Esto es equivalente a:
	Rectangulo rectangulo = session.getAttribute("rectangulo");
	if(rectangulo == null){
		rectangulo = new Rectangulo();
		session.setAttribute("rectangulo");
	} 
	-->
	<jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
	
	<!-- Recuperamos los valores y los desplegamos -->
	<br/>
	Valor base: <jsp:getProperty property="base" name="rectangulo"/>
	<br/>
	Valor Altura: <jsp:getProperty property="altura" name="rectangulo"/>
	<br/>
	<!-- En este caso, no importa que la propiedad no exista en el JB,
	solo con tener un metodo llamado getArea()
	es posible simular una propiedad  -->
	Valor Area: <jsp:getProperty property="area" name="rectangulo"/>
	<br/>
	<a href="index.jsp">Regresar al inicio</a>
</body>
</html>