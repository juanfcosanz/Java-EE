<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP que modifica un JB</title>
</head>
<body>
	<h1>JSP que modifica un JB</h1>
	<!-- Declaramos el JB a utilizar  -->
	<!-- El alcance de la variable es de tipo session -->
	<!-- Esta es equivalente a:
	
	Rectangulo rectangulo = new Rectangulo();
	session.setAttribute("rectangulo") -->
	
	<jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
	Modificamos los atributos:
	<br/>
	<br/>
	<%
	//Valores en codigo duro
	int baseValor = 5;
	int alturaValor = 10;
	%>
	<jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>"/>
	Nuevo valor base: <%=baseValor%>
	<br/>
	<jsp:setProperty property="altura" name="rectangulo" value="<%=alturaValor%>"/>
	Nuevo valor altura: <%=alturaValor%> 
	<br/>
	<br/>
	<a href="index.jsp">Regresar al inicio</a>
	

</body>
</html>