<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alcance de Variables</title>
</head>
<body>
	<h1>Alcance de Variables</h1>
	<br/>
	Variables request:
	Base: ${rectanguloRequest.base}
	Altura: ${rectanguloRequest.altura}
	Area: ${rectanguloRequest.area}
	<br/>
	<br/>
	Variables session:
	Base: ${rectanguloSession.base}
	Altura: ${rectanguloSession.altura}
	Area: ${rectanguloSession.area}
	<br/>
	<br/>
	variables Application:
	Base: ${rectanguloApplication.base}
	Altura: ${rectanguloApplication.altura}
	Area: ${rectanguloApplication.area}
	<br/>
	<br/>
	<a href="${pageContext.request.contextPath}/index.jsp">Regresar</a>
	

</body>
</html>